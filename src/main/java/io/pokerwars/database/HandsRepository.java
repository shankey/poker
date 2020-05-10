package io.pokerwars.database;

import io.pokerwars.bot.model.database.Hands;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface HandsRepository extends JpaRepositoryImplementation<Hands, Integer>{


}

