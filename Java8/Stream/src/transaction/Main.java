package transaction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

public class Main {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // (1) 找出2011年发生的所有交易，并按交易额排序（从低到高）。
        List<Transaction> transactions_2011=transactions.stream()
                                                        .filter(t->t.getYear()==2011)
                                                        .sorted(comparing(Transaction::getValue))
                                                        .collect(Collectors.toList());
        transactions_2011.stream().forEach(System.out::println);
        System.out.println("---------------------\n");
        // (2) 交易员都在哪些不同的城市工作过？
        List<String> cities=transactions.stream()
                                        .map(t->t.getTrader()
                                        .getCity())
                                        .distinct()
                                        .collect(Collectors.toList());
        cities.stream().forEach(System.out::println);
        System.out.println("---------------------\n");

        // (3) 查找所有来自于剑桥的交易员，并按姓名排序。
        List<Trader> listTrader=transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(comparing(Trader::getName))
                .collect(Collectors.toList());
        listTrader.stream().forEach(System.out::println);
        System.out.println("---------------------\n");

        // (4) 返回所有交易员的姓名字符串，按字母顺序排序。
        List<String> listName=transactions.stream()
                                            .map(transaction -> transaction.getTrader().getName())
                                            .distinct()
                                            .sorted()
                                            .collect(Collectors.toList());
        listName.stream().forEach(i->System.out.print(i+" "));
        System.out.println("\n---------------------\n");

        // (5) 有没有交易员是在米兰工作的？
        boolean MilanTrader=transactions.stream()
                                            .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        System.out.println(MilanTrader);
        System.out.println("---------------------\n");

        //(6) 打印生活在剑桥的交易员的所有交易额。
        int turnover=transactions.stream()
                                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                                .map(transaction -> transaction.getValue())
                                .reduce(0,Integer::sum);
        System.out.println("营业额="+turnover);
        System.out.println("---------------------\n");

        //(7) 所有交易中，最高的交易额是多少？
        Optional<Integer> maxValue=transactions.stream()
                .map(transaction -> transaction.getValue())
                .reduce(Integer::max);
        System.out.println("最高的交易额="+maxValue);
        System.out.println("---------------------\n");

        //(8) 找到交易额最小的交易
        Optional<Transaction> minTransaction=transactions.stream()
                                                            .min(comparing(Transaction::getValue));


        System.out.println(minTransaction);
    }
}
