package se.experis.assignment3hibernate.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.experis.assignment3hibernate.models.Character;
import se.experis.assignment3hibernate.models.Franchise;
import se.experis.assignment3hibernate.models.Movie;
import se.experis.assignment3hibernate.repositories.FranchiseRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class FranchiseService {
    @Autowired
    private FranchiseRepository franchiseRepository;

    public List<Movie> getAllMoviesInFranchise(Long id) {
        Franchise franchise = franchiseRepository.findById(id).get();
        return franchise.getMovies();
    }

    public List<Character> getAllCharactersInFranchise(Long id) {
        ArrayList<Character> characters = new ArrayList<>();
        List<Movie> allMovies = getAllMoviesInFranchise(id);
        for (Movie movie: allMovies) {
            for (Character character: movie.getCharacters()) {
                if (!characters.contains(character)){
                    characters.add(character);
                }
            }
        }
        return characters;
    }
}
