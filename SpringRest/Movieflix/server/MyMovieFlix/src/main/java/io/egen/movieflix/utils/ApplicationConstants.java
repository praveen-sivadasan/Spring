package io.egen.movieflix.utils;

/**
 * List of constants in database
 * 
 * @author psivadasan
 *
 */
public class ApplicationConstants {

	public static final int PAGINATION_SIZE = 10;
	public static final String APP_LOGOUT_SERVLET = "logout";
	public static final String APP_CONTEXT = "/MyMovieFlix";
	public static final String SESSION_USER_OBJECT = "userObject";

	/**
	 * Application Roles
	 *
	 */
	public static enum ApplicationRoles {
		ADMIN("Admin"), USER("User");
		private String role = null;;

		private ApplicationRoles(String role) {
			this.role = role;
		}

		public String getRole() {
			return role;
		}
	}

	/**
	 * List of codes from database
	 *
	 */
	public static enum Code {
		GENRE("genre"), COUNTRY("country"), LANGUAGE("language"), TITLE_RATING("title_rating"), TITLE_TYPE(
				"title_type"), GENDER("gender"), ROLE("role");
		private String name;

		private Code(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}
}
