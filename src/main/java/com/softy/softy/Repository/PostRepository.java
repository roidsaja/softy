package com.softy.softy.Repository;

import com.softy.softy.model.Post;

import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long>{
    
}
