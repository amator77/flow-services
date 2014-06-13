package flow.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import flow.entities.Window;
import flow.repositories.WindowRepository;

@Service
public class DummyDataInitializer {
	
	@Autowired
	public DummyDataInitializer(WindowRepository repository){
		
		Window w1 = new Window();
		w1.setName("w1");
		w1.setTest("aaaaaaaaaaaaa");
		
		Window w2 = new Window();
		w2.setTest("bbbbbbbbbbbbbbbbbbbbbbbbbbb");
		w2.setName("w2");
		
		repository.save(Arrays.asList(w1, w2));
	}
}
