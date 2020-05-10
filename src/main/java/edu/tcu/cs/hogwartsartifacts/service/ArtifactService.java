package edu.tcu.cs.hogwartsartifacts.service;

import edu.tcu.cs.hogwartsartifacts.dao.ArtifactDao;
import edu.tcu.cs.hogwartsartifacts.domain.Artifact;
import edu.tcu.cs.hogwartsartifacts.utils.IdWorker;

import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ArtifactService {

    private ArtifactDao artifactDao;
    private IdWorker idWorker;

    public ArtifactService(ArtifactDao artifactDao, IdWorker idWorker) {
        this.artifactDao = artifactDao;
        this.idWorker = idWorker;
    }

    public List<Artifact> findAll() {
        return artifactDao.findAll();
    }

    public Artifact findById(String artifactId) {
        return artifactDao.findById(artifactId).get();
    }

    public void save(Artifact newArtifact) {
        newArtifact.setId(idWorker.nextId() + "");
        artifactDao.save(newArtifact);
    }

    public void update(String artifactId, Artifact updatedArtifact) {
        updatedArtifact.setId(artifactId);
        artifactDao.save(updatedArtifact);
    }

    public void delete(String artifactId) {
        artifactDao.deleteById(artifactId);
    }
}
