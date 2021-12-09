package uk.ac.reigate.security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.ldap.core.DirContextOperations
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.ldap.userdetails.LdapAuthoritiesPopulator
import org.springframework.stereotype.Component

import uk.ac.reigate.domain.Person
import uk.ac.reigate.domain.security.Role
import uk.ac.reigate.services.PersonService

@Component
class AuthoritiesPopulator implements LdapAuthoritiesPopulator {

	@Autowired
	private PersonService userService;

	/**
	 * Default NoArgs constructor
	 */
	AuthoritiesPopulator() {}

	/**
	 * Default Autowired constructor	
	 * @param userService
	 */
	AuthoritiesPopulator(PersonService userService){
		this.userService = userService;
	}

	@Override
	public Collection<? extends GrantedAuthority> getGrantedAuthorities(DirContextOperations userData, String username) {
		Set userPerms = new HashSet();

		//get users permissions from service
		Person person = userService.findByUsername(username);

		for (Role perm : person.roles) {
			userPerms.add(new SimpleGrantedAuthority(perm.roleName));
		}
		return userPerms.toArray(new GrantedAuthority[userPerms.size()] );
	}

}