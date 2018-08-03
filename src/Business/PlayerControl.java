package Business;

import java.io.Serializable;

public interface PlayerControl extends Serializable{
	
	public String getName();
	
	public void setName(String name);
	
	public String getPassword();
	
}
