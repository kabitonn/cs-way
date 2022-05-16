import { arraySidebar } from "vuepress-theme-hope";

export const software = arraySidebar([
    {
        text: "系统设计",
        children: [
            "消息队列.md",
            "分布式.md",
            "攻击技术.md",
            "缓存.md",
            "集群.md",
            "微服务.md",
            "系统设计基础.md",
        ]
    },
]);

export const alg = arraySidebar([
    {
        text: "算法",
        children: [
            {
                text: "算法",
                link: "算法 - 目录.md"
            },
            {
                text: "Leetcode",
                link: "Leetcode 题解 - 目录.md"
            }
            , {
                text: "剑指offer",
                link: "剑指 Offer 题解 - 目录.md"
            }
        ]
    },
]);
export const oop = arraySidebar([
    {
        text: "面向对象",
        children: [
            "面向对象思想.md",
            "设计模式.md",
            "设计模式 - 目录.md",
        ]
    },
])

export const softquality = arraySidebar([
    {
        text: "面向对象",
        children: [
            "代码风格规范.md",
            "代码可读性.md",
        ]
    },
])