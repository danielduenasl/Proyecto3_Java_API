package miumg.edu.gt.Project3.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import miumg.edu.gt.Project3.Models.testModel;

@RestController
@RequestMapping("/api/test")
public class TestAPI {


	testModel model1 = new testModel(1,"Daniel", true);
	testModel model2 = new testModel(2,"Dani", false);
    List<testModel> ListModel = new ArrayList<>();
    
    


    @GetMapping("/")
    public String prueba() {
        return "Hola mundo";
    }


    @GetMapping("/model")
    public List<testModel> getModel() {
    	ListModel.add(model1);
    	ListModel.add(model2);
        return ListModel;
    }


    @GetMapping("/model/{id}")
    public ResponseEntity<testModel> getModelById(@PathVariable("id") int id) {
        Optional<testModel> model = ListModel.stream().filter(m -> m.getId() == id).findFirst();
        return model.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping("/model")
    public ResponseEntity<String> addModel(@RequestBody testModel model) {
        ListModel.add(model);
        return ResponseEntity.status(HttpStatus.CREATED).body("Modelo creado exitosamente");
    }

    @PutMapping("/model/{id}")
    public ResponseEntity<String> updateModel(@PathVariable("id") int id, @RequestBody testModel updatedModel) {
        Optional<testModel> existingModel = ListModel.stream().filter(m -> m.getId() == id).findFirst();
        if (existingModel.isPresent()) {
            ListModel.remove(existingModel.get());
            ListModel.add(updatedModel);
            return ResponseEntity.status(HttpStatus.OK).body("Modelo actualizado exitosamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Modelo no encontrado");
        }
    }

    @DeleteMapping("/model/{id}")
    public ResponseEntity<String> deleteModel(@PathVariable("id") int id) {
        Optional<testModel> model = ListModel.stream().filter(m -> m.getId() == id).findFirst();
        if (model.isPresent()) {
            ListModel.remove(model.get());
            return ResponseEntity.status(HttpStatus.OK).body("Modelo eliminado exitosamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Modelo no encontrado");
        }
    }

    @PostMapping("/model/name")
    public ResponseEntity<String> addModelByName(@RequestParam("name") String name) {
        testModel newModel = new testModel();
        newModel.setName(name);
        ListModel.add(newModel);
        return ResponseEntity.status(HttpStatus.CREATED).body("Modelo con nombre agregado exitosamente");
    }

}
