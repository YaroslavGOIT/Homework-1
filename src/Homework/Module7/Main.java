package Homework.Module7;

import Homework.Module4.Currency;
import Homework.Module6.UserUtils;

import java.util.*;
import java.util.stream.Collectors;

public class Main{
    private static int k=1;
    public static void main(String[] args) {
        User us = new User(14124, "firstName", "lastName", "Los Angels", 9999999);
        User us2 = new User(24124, "firstName2", "lastName2", "Los Angels", 9999999);
        User us3 = new User(34124, "firstName3", "lastName3", "Los Angeles", 9999999);
        User us4 = new User(44124, "firstName4", "lastName4", "Los Angels", 9999999);
        User us5 = new User(54124, "firstName5", "lastName5", "Los Angeles", 9999999);
        User us6 = new User(64124, "firstName6", "lastName6", "Los Angels", 9999999);
        User us7 = new User(74124, "firstName7", "lastName7", "Los Angeles", 9999999);
        User us8 = new User(84124, "firstName8", "lastName8", "Los Angeles", 9999999);
        User us9 = new User(94124, "firstName9", "lastName9", "Los Angels", 9999999);
        User us10 = new User(10124, "firstName10", "lastName10", "Los Angel", 9999999);

        Order rdr = new Order(91000001, 10, Currency.USD, "item", "Magazin", us);
        Order rdr2 = new Order(70000002, 900, Currency.EUR, "item2", "Magazin2", us2);
        Order rdr3 = new Order(20000003, 800, Currency.USD, "item3", "Magazin3", us3);
        Order rdr4 = new Order(60000004, 700, Currency.EUR, "item4", "Magazin4", us4);
        Order rdr5 = new Order(30000005, 400, Currency.USD, "item5", "Magazin5", us5);
        Order rdr6 = new Order(10000006, 600, Currency.EUR, "item6", "Magazin6", us6);
        Order rdr7 = new Order(10000007, 300, Currency.USD, "item7", "Magazin7", us7);
        Order rdr8 = new Order(10000008, 500, Currency.EUR, "item8", "Magazin8", us8);
        Order rdr9 = new Order(10000009, 200, Currency.USD, "item9", "Magazin9", us9);
        Order rdr10 = new Order(70040010, 100, Currency.EUR, "item10", "Magazin10", us10);


        List<Order> listOfOrder=new ArrayList<>();
        listOfOrder.add(rdr);
        listOfOrder.add(rdr2);
        listOfOrder.add(rdr3);
        listOfOrder.add(rdr4);
        listOfOrder.add(rdr5);
        listOfOrder.add(rdr6);
        listOfOrder.add(rdr7);
        listOfOrder.add(rdr8);
        listOfOrder.add(rdr9);
        listOfOrder.add(rdr10);
        System.out.println(listOfOrder);
        System.out.println(k+" =========================================================================\n");
        k++;

        Comparator<Order> price= (o1, o2) -> o2.getPrice()-o1.getPrice();

        Comparator<Order> priceAndCity= (o1, o2) -> {
            if(o1.getPrice()==o2.getPrice()){
                return UserUtils.alphabet(o1.getUser().getCity(),o2.getUser().getCity());
            }
            return o1.getPrice()-o2.getPrice();
        };


        Comparator<Order> cityAndShopId= (o1, o2) -> {
            if(Objects.equals(o1.getItemName(), o2.getItemName())) {
                if (UserUtils.alphabet(o1.getUser().getCity(), o2.getUser().getCity()) == 0) {
                    return o1.getPrice() - o2.getPrice();
                }
                if(o1.getPrice()==o2.getPrice()) {
                    return UserUtils.alphabet(o1.getShopIdentificator(), o2.getShopIdentificator());

                }
            }
            return UserUtils.alphabet(o1.getItemName(),o2.getItemName());
        };

        listOfOrder.sort(price);
        System.out.println(listOfOrder);
        System.out.println(k+" =========================================================================\n");
        k++;
        listOfOrder.sort(priceAndCity);
        System.out.println(listOfOrder);
        System.out.println(k+" =========================================================================\n");
        k++;
        listOfOrder.sort(cityAndShopId);
        System.out.println(listOfOrder);
        System.out.println(k+" =========================================================================\n");
        k++;

        Set<Order> hashList=new HashSet<>();
        hashList.addAll(listOfOrder);
        List<Order> list1=new ArrayList<>();
        list1.addAll(hashList);
        list1.removeIf(x -> (x.getPrice() < 150));//не 1500 потому что иначе масив будет пуст
        str(list1);

        List<Order> list2=list1.stream().filter(o->o.getCurrency()!=Currency.USD).collect(Collectors.toList());
        List<Order> list3=list1.stream().filter(o->o.getCurrency()!=Currency.EUR).collect(Collectors.toList());

        list3.removeIf(x -> (x.getCurrency()==Currency.EUR));
        list2.removeIf(x -> (x.getCurrency()==Currency.USD));
        str(list2);
        str(list3);

        Set<String> setList=list1.stream().map(o->o.getUser().getCity()).collect(Collectors.toSet());

        List<ArrayList<Order>> megaListCity;
        megaListCity=create2dArray(setList,list1);
        for (ArrayList<Order> aMegaListCity : megaListCity) {
            aMegaListCity.forEach(System.out::print);
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        }
        System.out.println(getK()+"========================================================================");
        setK(getK()+1);

    }

    private static void str(List<Order> or){
        System.out.println(or);
        System.out.println(Main.getK()+" =========================================================================\n");
        Main.setK(Main.getK()+1);
    }
    /**=============================*/
    private static List<Order> createCityArray(String string,List<Order> orders){
        List<Order> list=new ArrayList<>();
        for(Order order:orders){
            if(order.getUser().getCity()==string){
                list.add(order);
            }
        }
        return list;
    }
    private static List<ArrayList<Order>> create2dArray(Set<String> str,List<Order> orders){
        List<ArrayList<Order>> list2d=new ArrayList<>();
        for (String string:str) {
            list2d.add((ArrayList<Order>) createCityArray(string,orders));
        }
        return list2d;
    }
    /**================================*/
    public static int getK() {
        return k;
    }

    public static void setK(int k) {
        Main.k = k;
    }

}
