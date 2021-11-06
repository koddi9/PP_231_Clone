package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import web.dao.DaoImpl;
import web.dao.IDao;
import web.model.Car;
import web.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service("serviceImpl")
public class ServiceImpl implements IService{

    IDao dao;

    @Autowired
    public ServiceImpl(IDao dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public List<Car> getCarsList(String count) {
        if (count==null){
            count="5";
        }
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("BMW",5,"gray"));
        cars.add(new Car("2",2,"black"));
        cars.add(new Car("3",3,"white"));
        cars.add(new Car("4",4,"green"));
        cars.add(new Car("5",5,"red"));

        return cars.stream().limit(Integer.parseInt(count)).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<User> getUsersList(String count) {
        if (count==null){
            count="5";
        }
        List<User> users = new ArrayList<>();
       users.add(new User("Nick","Kad",(byte)24));
       users.add(new User("Ulya","Kad",(byte)26));
       users.add(new User("Den","Kad",(byte)29));

       for(User user:users){
           dao.add(user);
       }
       return dao.listUsers();
//        return users.stream().limit(Integer.parseInt(count)).collect(Collectors.toList());
    }

    @Override
    public void add(User user) {

    }
}
