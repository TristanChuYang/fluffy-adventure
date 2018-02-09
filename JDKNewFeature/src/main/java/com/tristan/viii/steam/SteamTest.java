package com.tristan.viii.steam;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SteamTest {

    //状态包含两个枚举
    private enum Status {
        OPEN, CLOSED
    }

    //Task类里有状态和分数两个属性
    private static final class Task {
        private final Status status;
        private final Integer points;

        Task( final Status status, final Integer points ) {
            this.status = status;
            this.points = points;
        }

        public Integer getPoints() {
            return points;
        }

        public Status getStatus() {
            return status;
        }

        @Override
        public String toString() {
            return String.format( "[%s, %d]", status, points );
        }
    }

    public static void main(String[] args) {

        //现在有一个task集合
        final Collection< Task > tasks = Arrays.asList(
                new Task( Status.OPEN, 5 ),
                new Task( Status.OPEN, 13 ),
                new Task( Status.CLOSED, 8 )
        );

        //如何计算出所有状态是OPEN的总分数呢
        final long totalPointsOfOpenTasks = tasks
                .stream() //首先先把集合转换成steam
                .filter( task -> task.getStatus() == Status.OPEN )//过滤出所有状态是OPEN的数据
                .mapToInt( Task::getPoints )// 调用每个task的getPoint方法
                .sum();//求和
        System.out.println("totalPointsOfOpenTasks=" + totalPointsOfOpenTasks);

        //
        final double totalPoints = tasks
                .stream()
                .parallel()//并行处理
                .filter( task -> task.getStatus() == Status.OPEN )
                .mapToInt( Task::getPoints )
                .sum();
        System.out.println("totalPoints=" + totalPoints);

        //根据元素分组
        final Map< Status, List< Task >> map = tasks
                .stream()
                .collect(Collectors.groupingBy(Task::getStatus));
        System.out.println(map);

    }

}
