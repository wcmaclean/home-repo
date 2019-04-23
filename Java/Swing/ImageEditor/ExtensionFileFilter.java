import java.io.File;
import javax.swing.filechooser.FileFilter;
import java.util.ArrayList;

class ExtensionFileFilter extends FileFilter{

	private String description = "";
	int initialCapacity = 10;
	private ArrayList<String> extensions = new ArrayList<String>(initialCapacity);
	
	public void addExtension(String extension){
		if (!extension.startsWith("."))
			extension = "." + extension;
		extensions.add(extension.toLowerCase());
	}

	public void setDescription(String aDescription){
		description = aDescription;
	}

	public String getDescription(){
		return description;
	}

	public boolean accept(File f){
		if(f.isDirectory()) return true;
		String name = f.getName().toLowerCase();

		for(String extension : extensions)
			if (name.endsWith(extension))
				return true;
		return false;
	}
	
}