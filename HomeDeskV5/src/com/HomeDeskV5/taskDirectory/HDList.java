package com.HomeDeskV5.taskDirectory;

import java.util.ArrayList;

public class HDList extends Container {
	private static final String SUFFIX = "list";
	
	private ArrayList<Section> sections;            // What sections and in what order does this HDList have
	
	private HDList() {
		super(SUFFIX, "null", null);
	}
	
	public HDList(String title, HDPath path) {
		super(SUFFIX, title, path);
		this.sections = new ArrayList<>();
		sections.add(new Section("Unsectioned"));
	}

	@Override
	public String toString(boolean bannerOnly) {
		StringBuilder sb = new StringBuilder();
		
		sb.append("[%s (List)");
		
		if (!isEmpty()) {
			sb.append(" {" + getNumElements() + "}");
		}
		
		sb.append("]");
		
		if (bannerOnly) {
			return sb.toString();
		} else {
			sb.append("\n");
		}
		
		// List containers
		// TODO List containers in HDList.toString()
		
		// List items
		// TODO List items in HDList.toString()
		
		
		return sb.toString();
	}

}
