const e={key:"v-2d766ab0",path:"/notes/%E7%AE%97%E6%B3%95/Leetcode%E9%A2%98%E8%A7%A3-%E4%BD%8D%E8%BF%90%E7%AE%97.html",title:"1. \u7EDF\u8BA1\u4E24\u4E2A\u6570\u7684\u4E8C\u8FDB\u5236\u8868\u793A\u6709\u591A\u5C11\u4F4D\u4E0D\u540C",lang:"zh-CN",frontmatter:{summary:"1. \u7EDF\u8BA1\u4E24\u4E2A\u6570\u7684\u4E8C\u8FDB\u5236\u8868\u793A\u6709\u591A\u5C11\u4F4D\u4E0D\u540C; 2. \u6570\u7EC4\u4E2D\u552F\u4E00\u4E00\u4E2A\u4E0D\u91CD\u590D\u7684\u5143\u7D20; 3. \u627E\u51FA\u6570\u7EC4\u4E2D\u7F3A\u5931\u7684\u90A3\u4E2A\u6570; 4. \u6570\u7EC4\u4E2D\u4E0D\u91CD\u590D\u7684\u4E24\u4E2A\u5143\u7D20; 5. \u7FFB\u8F6C\u4E00\u4E2A\u6570\u7684\u6BD4\u7279\u4F4D; 6. \u4E0D\u7528\u989D\u5916\u53D8\u91CF\u4EA4\u6362\u4E24\u4E2A\u6574\u6570; 7. \u5224\u65AD\u4E00\u4E2A\u6570\u662F\u4E0D\u662F 2 \u7684 n \u6B21\u65B9; 8. \u5224\u65AD\u4E00\u4E2A\u6570\u662F\u4E0D\u662F 4 \u7684 n \u6B21\u65B9; 9. \u5224\u65AD\u4E00\u4E2A\u6570\u7684\u4F4D\u7EA7\u8868\u793A\u662F\u5426\u4E0D\u4F1A\u51FA\u73B0\u8FDE\u7EED\u7684 0 \u548C 1; 10.",head:[["meta",{property:"og:url",content:"https://vuepress-theme-hope-v2-demo.mrhope.site/cs-way/notes/%E7%AE%97%E6%B3%95/Leetcode%E9%A2%98%E8%A7%A3-%E4%BD%8D%E8%BF%90%E7%AE%97.html"}],["meta",{property:"og:site_name",content:"CS Way"}],["meta",{property:"og:title",content:"1. \u7EDF\u8BA1\u4E24\u4E2A\u6570\u7684\u4E8C\u8FDB\u5236\u8868\u793A\u6709\u591A\u5C11\u4F4D\u4E0D\u540C"}],["meta",{property:"og:type",content:"article"}],["meta",{property:"og:updated_time",content:"2022-05-16T12:07:59.000Z"}],["meta",{property:"og:locale",content:"zh-CN"}],["meta",{property:"article:modified_time",content:"2022-05-16T12:07:59.000Z"}]]},excerpt:"",headers:[{level:1,title:"1. \u7EDF\u8BA1\u4E24\u4E2A\u6570\u7684\u4E8C\u8FDB\u5236\u8868\u793A\u6709\u591A\u5C11\u4F4D\u4E0D\u540C",slug:"_1-\u7EDF\u8BA1\u4E24\u4E2A\u6570\u7684\u4E8C\u8FDB\u5236\u8868\u793A\u6709\u591A\u5C11\u4F4D\u4E0D\u540C",children:[]},{level:1,title:"2. \u6570\u7EC4\u4E2D\u552F\u4E00\u4E00\u4E2A\u4E0D\u91CD\u590D\u7684\u5143\u7D20",slug:"_2-\u6570\u7EC4\u4E2D\u552F\u4E00\u4E00\u4E2A\u4E0D\u91CD\u590D\u7684\u5143\u7D20",children:[]},{level:1,title:"3. \u627E\u51FA\u6570\u7EC4\u4E2D\u7F3A\u5931\u7684\u90A3\u4E2A\u6570",slug:"_3-\u627E\u51FA\u6570\u7EC4\u4E2D\u7F3A\u5931\u7684\u90A3\u4E2A\u6570",children:[]},{level:1,title:"4. \u6570\u7EC4\u4E2D\u4E0D\u91CD\u590D\u7684\u4E24\u4E2A\u5143\u7D20",slug:"_4-\u6570\u7EC4\u4E2D\u4E0D\u91CD\u590D\u7684\u4E24\u4E2A\u5143\u7D20",children:[]},{level:1,title:"5. \u7FFB\u8F6C\u4E00\u4E2A\u6570\u7684\u6BD4\u7279\u4F4D",slug:"_5-\u7FFB\u8F6C\u4E00\u4E2A\u6570\u7684\u6BD4\u7279\u4F4D",children:[]},{level:1,title:"6. \u4E0D\u7528\u989D\u5916\u53D8\u91CF\u4EA4\u6362\u4E24\u4E2A\u6574\u6570",slug:"_6-\u4E0D\u7528\u989D\u5916\u53D8\u91CF\u4EA4\u6362\u4E24\u4E2A\u6574\u6570",children:[]},{level:1,title:"7. \u5224\u65AD\u4E00\u4E2A\u6570\u662F\u4E0D\u662F 2 \u7684 n \u6B21\u65B9",slug:"_7-\u5224\u65AD\u4E00\u4E2A\u6570\u662F\u4E0D\u662F-2-\u7684-n-\u6B21\u65B9",children:[]},{level:1,title:"8.  \u5224\u65AD\u4E00\u4E2A\u6570\u662F\u4E0D\u662F 4 \u7684 n \u6B21\u65B9",slug:"_8-\u5224\u65AD\u4E00\u4E2A\u6570\u662F\u4E0D\u662F-4-\u7684-n-\u6B21\u65B9",children:[]},{level:1,title:"9. \u5224\u65AD\u4E00\u4E2A\u6570\u7684\u4F4D\u7EA7\u8868\u793A\u662F\u5426\u4E0D\u4F1A\u51FA\u73B0\u8FDE\u7EED\u7684 0 \u548C 1",slug:"_9-\u5224\u65AD\u4E00\u4E2A\u6570\u7684\u4F4D\u7EA7\u8868\u793A\u662F\u5426\u4E0D\u4F1A\u51FA\u73B0\u8FDE\u7EED\u7684-0-\u548C-1",children:[]},{level:1,title:"10. \u6C42\u4E00\u4E2A\u6570\u7684\u8865\u7801",slug:"_10-\u6C42\u4E00\u4E2A\u6570\u7684\u8865\u7801",children:[]},{level:1,title:"11. \u5B9E\u73B0\u6574\u6570\u7684\u52A0\u6CD5",slug:"_11-\u5B9E\u73B0\u6574\u6570\u7684\u52A0\u6CD5",children:[]},{level:1,title:"12. \u5B57\u7B26\u4E32\u6570\u7EC4\u6700\u5927\u4E58\u79EF",slug:"_12-\u5B57\u7B26\u4E32\u6570\u7EC4\u6700\u5927\u4E58\u79EF",children:[]},{level:1,title:"13. \u7EDF\u8BA1\u4ECE 0 ~ n \u6BCF\u4E2A\u6570\u7684\u4E8C\u8FDB\u5236\u8868\u793A\u4E2D 1 \u7684\u4E2A\u6570",slug:"_13-\u7EDF\u8BA1\u4ECE-0-n-\u6BCF\u4E2A\u6570\u7684\u4E8C\u8FDB\u5236\u8868\u793A\u4E2D-1-\u7684\u4E2A\u6570",children:[]}],git:{createdTime:1652702879e3,updatedTime:1652702879e3,contributors:[{name:"chenwei.tjw",email:"chenwei.tjw@alibaba-inc.com",commits:1}]},readingTime:{minutes:8.5,words:2551},filePathRelative:"notes/\u7B97\u6CD5/Leetcode\u9898\u89E3-\u4F4D\u8FD0\u7B97.md"};export{e as data};
