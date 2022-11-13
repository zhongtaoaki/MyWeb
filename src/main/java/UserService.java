import java.util.HashMap;
import java.util.Map;

public class UserService {

	private static Map<String, User> map = new HashMap<>();

	public static User findByUsername(String username) {
		return map.get(username);
	}

	public static boolean createUser(User user) {
		if (map.containsKey(user.getUsername())) {
			return false;
		} else {
			map.put(user.getUsername(), user);
			return true;
		}
	}

}
