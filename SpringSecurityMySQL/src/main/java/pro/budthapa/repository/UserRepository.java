package pro.budthapa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pro.budthapa.domain.AppUser;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Integer>{
	public Optional<AppUser> findByUsername(String name);
}
