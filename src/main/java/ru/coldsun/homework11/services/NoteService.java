package ru.coldsun.homework11.services;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.coldsun.homework11.aspect.TrackUserAction;
import ru.coldsun.homework11.exception.NoteNotFoundException;
import ru.coldsun.homework11.model.Note;
import ru.coldsun.homework11.repository.NoteRepository;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;

    @TrackUserAction
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }
    @TrackUserAction
    public Note getByIdNotes(Long id) {
        return noteRepository.findById(id).orElseThrow(()-> new NoteNotFoundException("Заметка " + id + " не найдена!"));
    }
    @TrackUserAction
    public void deleteByNotes(Long id) {
        noteRepository.deleteById(id);
    }

    /**
     * Добавление заметки.
     * Всегда устанавливает текущую дату создания (@CreationDate)
     * При отсутствии описания (@Content) добавляет описание(@Content) из заголовка @Heading
     */
    @TrackUserAction
    public Note addNotes(Note note) {
        note.setCreationDate(LocalDateTime.now());
        if (note.getContent()==null) note.setContent(note.getHeading());
        return  noteRepository.save(note);
    }
    @TrackUserAction
    public Note updateNoteStatus(Long id, Note note) {
        Note changeNote = noteRepository.findById(id).orElse(null);
        if (changeNote != null) {
            if (note.getContent()!=null) changeNote.setContent(note.getContent());
            if (note.getHeading()!=null) changeNote.setHeading(note.getHeading());
            if (note.getCreationDate()!=null) changeNote.setCreationDate(note.getCreationDate());
            return noteRepository.save(changeNote);
        } else {
            return null;
        }
    }

    @TrackUserAction
    public List<Note> sortAllNotes() {
        List<Note> changeNote = noteRepository.findAll();
        return changeNote.stream()
                .sorted(Comparator.comparing(Note::getCreationDate))
                .collect(Collectors.toList());
    }
}
