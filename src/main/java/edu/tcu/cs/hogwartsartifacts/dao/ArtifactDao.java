package edu.tcu.cs.hogwartsartifacts.dao;

import edu.tcu.cs.hogwartsartifacts.domain.Artifact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtifactDao extends JpaRepository<Artifact, String> {
}
