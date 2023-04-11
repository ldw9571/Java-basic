package day12.lambda;

import day07.util.Utility;

import java.util.List;

import static day12.lambda.Color.*;
import static day12.lambda.FilterApple.*;

public class Main {

    public static void main(String[] args) {

        // 사과 바구니 생성
        List<Apple> appleBasket = List.of(
                new Apple(80, GREEN)
                , new Apple(155, GREEN)
                , new Apple(120, RED)
                , new Apple(97, RED)
                , new Apple(200, GREEN)
                , new Apple(50, RED)
                , new Apple(85, YELLOW)
                , new Apple(75, YELLOW)
        );

        System.out.println("========= 녹색 사과 필터링 ========");
        List<Apple> greenApples
                = filterGreenApples(appleBasket);
        for (Apple greenApple : greenApples) {
            System.out.println(greenApple);
        }

        System.out.println("======= 노랑 사과 필터링 =========");
        List<Apple> colorApples
                = filterApplesByColor(appleBasket, YELLOW);

        for (Apple ca : colorApples) {
            System.out.println(ca);
        }

        System.out.println("======= 원하는 조건으로 필터링 ======");

        // 100g 이하 사과들
        List<Apple> filterApples
                = filterApples(appleBasket, new LightApplePredicate());
        for (Apple filterApple : filterApples) {
            System.out.println(filterApple);
        }

        Utility.makeLine();
        // 빨강 사과 필터링
        List<Apple> filterApples1 = filterApples(appleBasket, new ApplePredicate() {

            @Override
            public boolean test(Apple apple) {
                return apple.getColor() == RED;
            }
        });
        for (Apple apple : filterApples1) {
            System.out.println(apple);
        }

        Utility.makeLine();

        // 녹색이면서 100g보다 큰 사과들만 필터링 (익명)

    }
}
