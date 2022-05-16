import { arraySidebar } from "vuepress-theme-hope";

export const database = arraySidebar([
    {
        text: "数据库",
        children: [
            "SQL.md",
            "数据库系统原理.md",
            "Leetcode-Database题解.md",
            "MySQL.md",
            "Redis.md",
        ]
    },
]);

export const os = arraySidebar([
    {
        text: "操作系统",
        children: [
            "计算机操作系统-概述",
            "计算机操作系统-进程管理",
            "计算机操作系统-死锁",
            "计算机操作系统-内存管理",
            "计算机操作系统-设备管理",
            "计算机操作系统-链接",
        ]
    },
    "Linux"
]);

export const network = arraySidebar([
    {
        text: "计算机网络",
        children: [
            "计算机网络-概述",
            "计算机网络-传输层",
            "计算机网络-链路层",
            "计算机网络-网络层",
            "计算机网络-物理层",
            "计算机网络-应用层"
        ]
    },

    "HTTP",
    "Netty",
    "Socket",
]);