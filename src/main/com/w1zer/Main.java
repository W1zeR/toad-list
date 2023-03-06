package main.com.w1zer;

import main.com.w1zer.entity.Toad;
import main.com.w1zer.repository.ConnectionFactory;
import main.com.w1zer.repository.ToadRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ToadRepository toadRepository = new ToadRepository(new ConnectionFactory());
        Toad toad = toadRepository.getById(1);
        System.out.println(toad.getName());
        toad.setName("Тестовая жаба");
        toadRepository.insert(toad);
        toadRepository.update(toad);
        toadRepository.delete(14);
        List<Toad> toads = toadRepository.getByIdProfile(1);
        System.out.println(toads.size());
    }
}
