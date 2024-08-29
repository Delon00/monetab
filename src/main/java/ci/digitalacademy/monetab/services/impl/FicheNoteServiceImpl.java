package ci.digitalacademy.monetab.services.impl;

import ci.digitalacademy.monetab.models.FicheNote;
import ci.digitalacademy.monetab.repository.FicheNoteRepository;
import ci.digitalacademy.monetab.services.DTO.FicheNoteDTO;
import ci.digitalacademy.monetab.services.FicheNoteService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class FicheNoteServiceImpl implements FicheNoteService {

    private final FicheNoteRepository ficheNoteRepository;

    @Override
    public FicheNote save(FicheNote ficheNote) {
        return ficheNoteRepository.save(ficheNote);
    }

    @Override
    public FicheNote update(FicheNote ficheNote) {
        log.debug("Requête pour mettre à jour la fiche de note {}", ficheNote);
        return findOne(ficheNote.getId())
                .map(existingFicheNote -> {
                    existingFicheNote.setNote(ficheNote.getNote());
                    existingFicheNote.setAnnee(ficheNote.getAnnee());
                    existingFicheNote.setDateCreation(ficheNote.getDateCreation());
                    return save(existingFicheNote);
                })
                .orElseThrow(() -> new EntityNotFoundException
                        ("Aucune fiche de note avec cet id n'a été retrouvée " + ficheNote.getId()));
    }

    @Override
    public FicheNoteDTO save(FicheNoteDTO ficheNote) {
        return null;
    }

    @Override
    public FicheNoteDTO update(FicheNoteDTO ficheNote) {
        return null;
    }

    @Override
    public Optional<FicheNote> findOne(Long id) {
        return ficheNoteRepository.findById(id);
    }

    @Override
    public List<FicheNote> findAll() {
        return ficheNoteRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        ficheNoteRepository.deleteById(id);
    }
}
