package aa.TomcatRealm;



//http://www.matjazcerkvenik.si/developer/java-tomcat-custom-realm.php
// http://www.techpaste.com/2013/11/protect-access-resource-memory-realm-tomcat/


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

		System.out.println("Entering tomcatRealmTest1.authenticate");
		/* dummy authentication */
		if (this.username.equals(this.password)) {
			System.out.println("tomcatRealmTest1.authenticated");
			return getPrincipal(username);
		} else {
			System.out.println("tomcatRealmTest1.not.authenticated");
			return null;
		}

	}

	@Override
	protected Principal getPrincipal(String username) {
		System.out.println("Entering tomcatRealmTest1.getPrincipal");
		List<String> roles = new ArrayList<String>();
		roles.add("manager");
		roles.add("tomcat");
		return new GenericPrincipal(username, password, roles);
	}

	@Override
	protected String getPassword(String string) {
		System.out.println("Entering tomcatRealmTest1.getPassword");
		return password;
	}

	@Override
	protected String getName() {
		System.out.println("Entering tomcatRealmTest1.getName");
		return username;
	}

	/* Custom variables, see <Realm> element */
	private String myVariable;

	public String getMyVariable() {
		System.out.println("Entering tomcatRealmTest1.getMyVariable");
		return myVariable;
	}

	public void setMyVariable(String myVariable) {
		System.out.println("Entering tomcatRealmTest1.setMyVariable");
		this.myVariable = myVariable;
	}


}
