package com.HomeDeskV5.taskDirectory;

import java.util.ArrayList;

import com.HomeDeskV5.ToDoItem;

public class HDList extends Container {
	private static final String SUFFIX = "LIST";
	
	private ArrayList<Section> sections;            // What sections and in what order does this HDList have
	
	private HDList() {
		super(SUFFIX, null);
	}
	
	public HDList(String title, HDPath path) {
		super(SUFFIX, path);
		this.setTitle(title);
		this.getPath().extend(this);
		this.sections = new ArrayList<>();
		sections.add(new Section("Unsectioned"));
	}

	@Override
	public boolean isEmpty() {
		return (this.getContainers().size() == 0 && this.getItems().size() == 0);
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
		for (Container c:this.getContainers()) {
			sb.append("\t" + c.getTitle() + " (" + c.getClass().toString() + ")");
			if (!c.isEmpty()) {
				sb.append(" [" + c.getNumElements() + "]\n");
			}
		}
		
		// List items
		for (ToDoItem tdi:this.getItems()) {
			sb.append("\t" + tdi.getTitle() + " (" + tdi.getClass().toString() + ")\n");
		}
		
		return sb.toString();
	}

}
