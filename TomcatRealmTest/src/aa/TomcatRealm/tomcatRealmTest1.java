package aa.TomcatRealm;



//http://www.matjazcerkvenik.si/developer/java-tomcat-custom-realm.php


import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import org.apache.catalina.realm.GenericPrincipal;
import org.apache.catalina.realm.RealmBase;


public class tomcatRealmTest1 extends RealmBase {

	private String username;

	private String password;

	@Override
	public Principal authenticate(String username, String credentials) {

		this.username = username;
		this.password = credentials;

		/* dummy authentication */
		if (this.username.equals(this.password)) {
			return getPrincipal(username);
		} else {
			return null;
		}

	}

	@Override
	protected Principal getPrincipal(String username) {
		List<String> roles = new ArrayList<String>();
		roles.add("manager");
		return new GenericPrincipal(username, password, roles);
	}

	@Override
	protected String getPassword(String string) {
		return password;
	}

	@Override
	protected String getName() {
		return username;
	}

	/* Custom variables, see <Realm> element */
	private String myVariable;

	public String getMyVariable() {
		return myVariable;
	}

	public void setMyVariable(String myVariable) {
		this.myVariable = myVariable;
	}


}
