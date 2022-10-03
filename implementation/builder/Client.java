package implementation.builder;

import java.time.LocalDate;

//This is our client which also works as "director"
public class Client {

	public static void main(String[] args) {
		User user = createUser();
		// Client has to provide director with concrete builder
		UserWebDTOBuilder builder = new UserWebDTOBuilder();
		UserDTO dto = directBuild(builder, user);
		System.out.println(dto);
		System.out.println();

		// Another way to implement builde design pattern
		// we keep all the attributes of UserDTO private and only builder can modify those properties.
		// Also, as these properties are private, builder needs to be defined as a subclass under the same class
		// In this way, we keep UserDTO immutable
		OtherUserDTO otherDTO = OtherdirectBuild(OtherUserDTO.getBuilder(), user);
		System.out.println(otherDTO);
	}

	// This method serves the role of director in builder pattern.
	public static UserDTO directBuild(UserDTOBuilder builder, User user){
		return builder.withFirstName(user.getFirstName())
				.withLastName(user.getLastName())
				.withBirthday(user.getBirthday())
				.withAddress(user.getAddress())
				.build();
	}

	// This method serves the role of director in builder pattern.
	public static OtherUserDTO OtherdirectBuild(OtherUserDTO.UserDTOBuilder builder, User user){
		return builder.withFirstName(user.getFirstName())
				.withLastName(user.getLastName())
				.withBirthday(user.getBirthday())
				.withAddress(user.getAddress())
				.build();
	}
	
	/**
	 * Returns a sample user. 
	 */
	public static User createUser() {
		User user = new User();
		user.setBirthday(LocalDate.of(1960, 5, 6));
		user.setFirstName("Ron");
		user.setLastName("Swanson");
		Address address = new Address();
		address.setHouseNumber("100");
		address.setStreet("State Street");
		address.setCity("Pawnee");
		address.setState("Indiana");
		address.setZipcode("47998");
		user.setAddress(address);
		return user;
	}
}
