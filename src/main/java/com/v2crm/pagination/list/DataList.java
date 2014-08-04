package com.v2crm.pagination.list;

import java.util.ArrayList;
import java.util.List;

import org.displaytag.pagination.PaginatedList;
import org.displaytag.properties.SortOrderEnum;

public class DataList implements PaginatedList{
	  private final int itemsPerPage = 25; // default

	    private List list;
	    private int fullListSize;
	    private int objectsPerPage;
	    private int pageNumber;
	    private String searchId; // for database cache, i do not use
	    private String sortCriterion;
	    private SortOrderEnum sortDirection;

	    // get from parameter
	    private int sortItemNo;

		public List getList() {
			return list;
		}

		public void setList(List list) {
			this.list = list;
		}

		public int getFullListSize() {
			return fullListSize;
		}

		public void setFullListSize(int fullListSize) {
			this.fullListSize = fullListSize;
		}

		public int getObjectsPerPage() {
			return objectsPerPage;
		}

		public void setObjectsPerPage(int objectsPerPage) {
			this.objectsPerPage = objectsPerPage;
		}

		public int getPageNumber() {
			return pageNumber;
		}

		public void setPageNumber(int pageNumber) {
			this.pageNumber = pageNumber;
		}

		public String getSearchId() {
			return searchId;
		}

		public void setSearchId(String searchId) {
			this.searchId = searchId;
		}

		public String getSortCriterion() {
			return sortCriterion;
		}

		public void setSortCriterion(String sortCriterion) {
			this.sortCriterion = sortCriterion;
		}

		public SortOrderEnum getSortDirection() {
			return sortDirection;
		}

		public void setSortDirection(SortOrderEnum sortDirection) {
			this.sortDirection = sortDirection;
		}

		public int getSortItemNo() {
			return sortItemNo;
		}

		public void setSortItemNo(int sortItemNo) {
			this.sortItemNo = sortItemNo;
		}

		public int getItemsPerPage() {
			return itemsPerPage;
		}
	    
	    
	
}
