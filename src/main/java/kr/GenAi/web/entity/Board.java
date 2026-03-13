package kr.GenAi.web.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long b_idx;
	
	private String b_title;
	
	private String b_content;
	
	@Column(updatable = false)	// update 시 작성자 수정 불가
	private String b_writer;
	
	private String b_file_path;
	
	// MM : 월로 인식
	// mm : 분으로 인식
	
	@JsonFormat(pattern= "yyyy-MM-dd", timezone = "Asia/Seoul")
	@Column(insertable = false, updatable = false, columnDefinition = "datetime default now()")
	private LocalDateTime b_create_at;
}
