package payrollweb.itprofound.core;

import java.util.List;

import org.springframework.data.domain.Page;

public class BasePageResponse<T> {

	private List<T> records;

	private int totalPages;

	private long totalRecords;
	
	public List<T> getRecords() {
		return records;
	}

	public void setRecords(List<T> records) {
		this.records = records;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public long getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(long totalRecords) {
		this.totalRecords = totalRecords;
	}

	public BasePageResponse() {

	}

	public BasePageResponse(Page<T> pagedData) {
		this.setRecords(pagedData.getContent());
		this.totalRecords = pagedData.getTotalElements();
		this.totalPages = pagedData.getTotalPages();
	}
}