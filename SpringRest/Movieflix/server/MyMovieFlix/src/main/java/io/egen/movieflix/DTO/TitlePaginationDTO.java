package io.egen.movieflix.DTO;

import java.util.List;

import lombok.Data;

@Data
public class TitlePaginationDTO {
	private String fromIndex;
	private String toIndex;
	
	private String titleTypeId;
	private String year;
	private String genre;
	private boolean viewTopRated;
	private String title;
	private List<TitleDTO> titleList;	
}
