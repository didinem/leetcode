import java.util.*;

/**
 * Created by zhongzhengmin on 2017/10/16.
 */
public class Lunch {

    static List<Restaurant> candidates;

    static {
        candidates = new ArrayList<>();
//        candidates.add(new Restaurant(1, "汉堡王（118广场20864）", PlatformEnum.MEITUAN, 5));
//        candidates.add(new Restaurant(2, "新亚大包（真中店）", PlatformEnum.MEITUAN, 2));
//        candidates.add(new Restaurant(3, "耶里夏丽新疆餐厅（中环店）", PlatformEnum.MEITUAN, 10));
//        candidates.add(new Restaurant(4, "避风塘（中环店）", PlatformEnum.MEITUAN, 10));
//        candidates.add(new Restaurant(5, "甜蜜蜜港式茶餐厅（梅川店）", PlatformEnum.MEITUAN, 5));
//        candidates.add(new Restaurant(6, "福建沙县小吃", PlatformEnum.MEITUAN, 4));
//        candidates.add(new Restaurant(7, "丰收日（近铁广场店）", PlatformEnum.MEITUAN, 10));
//        //candidates.add(new Restaurant("杨铭宇黄焖鸡米饭", PlatformEnum.MEITUAN, 2));
//        candidates.add(new Restaurant(8, "饭戒", PlatformEnum.MEITUAN, 4));
//        candidates.add(new Restaurant(9, "真功夫（百联中环）", PlatformEnum.MEITUAN, 5));
//        candidates.add(new Restaurant(10, "一茶一坐（百联中环）", PlatformEnum.MEITUAN, 10));
//        candidates.add(new Restaurant(11, "食其家（118广场店）", PlatformEnum.MEITUAN, 4));
//        //candidates.add(new Restaurant("小杨生煎（小杨生煎118店）", PlatformEnum.MEITUAN, 2));
//        candidates.add(new Restaurant(12, "港式铁板炒饭（曹杨店）", PlatformEnum.MEITUAN, 4));
//        candidates.add(new Restaurant(13, "阿拉丁麻辣烫（118广场店）", PlatformEnum.MEITUAN, 15));
//        candidates.add(new Restaurant(14, "德克士（北石）", PlatformEnum.ELEME, 20));
//        //candidates.add(new Restaurant("杨铭宇黄焖鸡米饭", PlatformEnum.ELEME, 2));
//        candidates.add(new Restaurant(15, "永和大王（兰溪路店SH023）", PlatformEnum.ELEME, 2));
//        candidates.add(new Restaurant(16, "老盛昌汤包馆（118店）", PlatformEnum.ELEME, 2));
//        candidates.add(new Restaurant(17, "牧场物语（曹杨路店）", PlatformEnum.ELEME, 5));
//        //candidates.add(new Restaurant("小杨生煎（118广场店）", PlatformEnum.MEITUAN, 2));
//        candidates.add(new Restaurant(18, "一茶一坐（百联中环）", PlatformEnum.BAIDU, 10));
        candidates.add(new Restaurant(1, "大食堂", PlatformEnum.OUTSIDE, 3));

    }

    public static List<ChooseResult> initChooseResult() {
        List<ChooseResult> chooseResults = new ArrayList<>(candidates.size());
        for (Restaurant restaurant : candidates) {
            chooseResults.add(new ChooseResult(restaurant, 0));
        }

        return chooseResults;
    }

    public static Map<Long, List<Restaurant>> initBrand() {
        Map<Long, List<Restaurant>> map = new HashMap<>();
        for (Restaurant restaurant : candidates) {
            List<Restaurant> newRestaurants = new ArrayList<>();
            newRestaurants.add(restaurant);
            List<Restaurant> restaurants = map.putIfAbsent(restaurant.getBrandId(), newRestaurants);
            if (restaurants != null) {
                restaurants.add(restaurant);
            }
        }
        return map;
    }

    public static List<Restaurant> chooseRestaurantByBrand() {
        List<ChooseResult> chooseResults = initChooseResult();
        Map<Long, List<Restaurant>> brandMap = initBrand();
        Long brandId = null;

        boolean chooseOver = false;
        while (!chooseOver) {
            Random random = new Random();
            int index = random.nextInt(chooseResults.size());
            ChooseResult chooseResult = chooseResults.get(index);
            chooseResult.setHit(chooseResult.getHit() + 1);
//            System.out.println(String.format("第%d次抽中了%s", chooseResult.getHit(), chooseResult.getRestaurant().getName()));
            if (chooseResult.getRestaurant().getWeight() == chooseResult.getHit()) {
                chooseOver = true;
                brandId = chooseResult.getRestaurant().getBrandId();
            }
        }

        return brandMap.get(brandId);
    }

    public static void main(String[] args) {
//        int i = 1;
//        while (i <= 20) {
            List<Restaurant> results = chooseRestaurantByBrand();
            System.out.println(results);
//            i++;
//        }
    }

    private static class ChooseResult {

        private Restaurant restaurant;

        private int hit;

        public ChooseResult(Restaurant restaurant, int hit) {
            this.restaurant = restaurant;
            this.hit = hit;
        }

        public Restaurant getRestaurant() {
            return restaurant;
        }

        public void setRestaurant(Restaurant restaurant) {
            this.restaurant = restaurant;
        }

        public int getHit() {
            return hit;
        }

        public void setHit(int hit) {
            this.hit = hit;
        }
    }

    private static class Restaurant {

        private long brandId;

        private String name;

        private PlatformEnum platform;

        private int weight;

        public Restaurant(long brandId, String name, PlatformEnum platform, int weight) {
            this.brandId = brandId;
            this.name = name;
            this.platform = platform;
            this.weight = weight;
        }

        public long getBrandId() {
            return brandId;
        }

        public void setBrandId(long brandId) {
            this.brandId = brandId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public PlatformEnum getPlatform() {
            return platform;
        }

        public void setPlatform(PlatformEnum platform) {
            this.platform = platform;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Restaurant{" +
                    "brandId=" + brandId +
                    ", name='" + name + '\'' +
                    ", platform=" + platform +
                    ", weight=" + weight +
                    '}';
        }
    }

    private enum PlatformEnum {
        MEITUAN, ELEME, BAIDU, OUTSIDE
    }

}
