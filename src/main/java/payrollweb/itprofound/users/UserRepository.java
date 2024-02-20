package payrollweb.itprofound.users;

import java.util.Optional;
import org.springframework.stereotype.Repository;
import payrollweb.itprofound.core.BaseRepository;
import payrollweb.itprofound.models.User;

@Repository
public interface UserRepository extends BaseRepository<User, String>{

	Optional<User> findByUserName(String username);

	Optional<User> findByEmail(String email); 
}
