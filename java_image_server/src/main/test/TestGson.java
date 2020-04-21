import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.HashMap;

/*
测试GSON
GSON是Google提供的用来在Java对象和JSON数据之间进行映射的Java类库。可以将一个Json字符转成一个Java对象，或者将一个Java转化为Json字符串。
两个方法：
public String toJson(Objcet obj)方法，可以将对象转化为json字符串。
public T fromJson(String jsonStr,T.class)方法，可以将json字符串转化为Java对象 
特点： a、快速、高效
    　　b、代码量少、简洁
    　　c、面向对象
       　d、数据传递和解析方便
 
Gson的pom依赖：
        <dependency>
            <groupId>com.google.code.gson</groupId>
            <artifactId>gson</artifactId>
            <version>2.8.0</version>
        </dependency>
*/
class Hero {
    public String name;
    public String skill1;
    public String skill2;
    public String skill3;
    public String skill4;
}

public class TestGson {
    public static void main(String[] args) {
        //可以用hashMap模拟
//        HashMap<String, Object> hashMap = new HashMap<>();
//        hashMap.put("name", "曹操");
//        hashMap.put("skill1", "剑气");
//        hashMap.put("skill2", "三段跳");
//        hashMap.put("skill3", "加攻击并吸血");
//        hashMap.put("skill4", "加攻速");
        Hero hero = new Hero();
        hero.name = "曹操";
        hero.skill1 = "剑气";
        hero.skill2 = "三段跳";
        hero.skill3 = "加攻击并吸血";

        // 通过 map 转成 JSON 结构的字符串
        // 1. 创建一个 gson 对象
        Gson gson = new GsonBuilder().create();
        // 2. 使用 toJson 方法把键值对结构转成 JSON 字符串
        String str = gson.toJson(hero);
        System.out.println(str);
    }
}
