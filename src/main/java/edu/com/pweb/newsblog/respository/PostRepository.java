package edu.com.pweb.newsblog.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.com.pweb.newsblog.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post,Long>{

}
