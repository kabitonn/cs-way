import { arraySidebar } from "vuepress-theme-hope";

export const java = arraySidebar([
    {
        text: "Java",
        children: [
            "Java 并发基础.md",
            "Java 并发进阶.md",
            "Java 基础.md",
            "Java 容器.md",
            "Java 特性.md",
            "Java 虚拟机-内存管理.md",
            "Java 虚拟机-执行系统.md",
            "Java 虚拟机-JVM调优.md",
            "Java EE.md",
            "Java IO.md",
        ]
    },
]);


export const fe = arraySidebar([
    {
        text: "前端",
        children: [
            "前端基础.md",
            "JavaScript.md",
            "JS-进阶.md",

        ]
    },
]);

export const mw = arraySidebar([
    {
        text: "中间件",
        children: [
            "分布式搜索.md",
            "分布式调度.md",
            "分布式服务.md",
            "分布式缓存.md",
            "分布式计算.md",
            "分布式事务.md",
            "分布式数据库.md",
            "分布式消息.md",
            "分布式中间件.md",
            "配置中心.md",
        ]
    },
]);
export const framework = arraySidebar([
    {
        text: "框架",
        children: [
            "Spring-MVC.md",
            "Dubbo.md",
            "Kafka.md",
            "Pandora Boot.md",
            "RabbitMQ.md",
            "Spring.md",
            "SpringBoot.md",
            "Zookeeper.md",
        ]
    },
]);
