const e={key:"v-e341d2bc",path:"/notes/%E7%AE%97%E6%B3%95/Leetcode%E9%A2%98%E8%A7%A3-%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92.html",title:"\u6590\u6CE2\u90A3\u5951\u6570\u5217",lang:"zh-CN",frontmatter:{summary:"\u6590\u6CE2\u90A3\u5951\u6570\u5217; 1. \u722C\u697C\u68AF; 2. \u5F3A\u76D7\u62A2\u52AB; 3. \u5F3A\u76D7\u5728\u73AF\u5F62\u8857\u533A\u62A2\u52AB; 4. \u4FE1\u4EF6\u9519\u6392; 5. \u6BCD\u725B\u751F\u4EA7; \u77E9\u9635\u8DEF\u5F84; 1. \u77E9\u9635\u7684\u6700\u5C0F\u8DEF\u5F84\u548C; 2. \u77E9\u9635\u7684\u603B\u8DEF\u5F84\u6570; \u6570\u7EC4\u533A\u95F4; 1. \u6570\u7EC4\u533A\u95F4\u548C; 2. \u6570\u7EC4\u4E2D\u7B49\u5DEE\u9012\u589E\u5B50\u533A\u95F4\u7684\u4E2A\u6570; \u5206\u5272\u6574\u6570; 1. \u5206\u5272\u6574\u6570\u7684\u6700\u5927\u4E58\u79EF; 2. \u6309\u5E73\u65B9\u6570\u6765\u5206\u5272\u6574\u6570; 3. \u5206\u5272\u6574\u6570\u6784\u6210\u5B57\u6BCD\u5B57\u7B26\u4E32; \u6700\u957F\u9012\u589E\u5B50\u5E8F\u5217;",head:[["meta",{property:"og:url",content:"https://vuepress-theme-hope-v2-demo.mrhope.site/cs-way/notes/%E7%AE%97%E6%B3%95/Leetcode%E9%A2%98%E8%A7%A3-%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92.html"}],["meta",{property:"og:site_name",content:"CS Way"}],["meta",{property:"og:title",content:"\u6590\u6CE2\u90A3\u5951\u6570\u5217"}],["meta",{property:"og:type",content:"article"}],["meta",{property:"og:updated_time",content:"2022-05-16T12:07:59.000Z"}],["meta",{property:"og:locale",content:"zh-CN"}],["meta",{property:"article:modified_time",content:"2022-05-16T12:07:59.000Z"}]]},excerpt:"",headers:[{level:1,title:"\u6590\u6CE2\u90A3\u5951\u6570\u5217",slug:"\u6590\u6CE2\u90A3\u5951\u6570\u5217",children:[{level:2,title:"1. \u722C\u697C\u68AF",slug:"_1-\u722C\u697C\u68AF",children:[]},{level:2,title:"2. \u5F3A\u76D7\u62A2\u52AB",slug:"_2-\u5F3A\u76D7\u62A2\u52AB",children:[]},{level:2,title:"3. \u5F3A\u76D7\u5728\u73AF\u5F62\u8857\u533A\u62A2\u52AB",slug:"_3-\u5F3A\u76D7\u5728\u73AF\u5F62\u8857\u533A\u62A2\u52AB",children:[]},{level:2,title:"4. \u4FE1\u4EF6\u9519\u6392",slug:"_4-\u4FE1\u4EF6\u9519\u6392",children:[]},{level:2,title:"5. \u6BCD\u725B\u751F\u4EA7",slug:"_5-\u6BCD\u725B\u751F\u4EA7",children:[]}]},{level:1,title:"\u77E9\u9635\u8DEF\u5F84",slug:"\u77E9\u9635\u8DEF\u5F84",children:[{level:2,title:"1. \u77E9\u9635\u7684\u6700\u5C0F\u8DEF\u5F84\u548C",slug:"_1-\u77E9\u9635\u7684\u6700\u5C0F\u8DEF\u5F84\u548C",children:[]},{level:2,title:"2. \u77E9\u9635\u7684\u603B\u8DEF\u5F84\u6570",slug:"_2-\u77E9\u9635\u7684\u603B\u8DEF\u5F84\u6570",children:[]}]},{level:1,title:"\u6570\u7EC4\u533A\u95F4",slug:"\u6570\u7EC4\u533A\u95F4",children:[{level:2,title:"1. \u6570\u7EC4\u533A\u95F4\u548C",slug:"_1-\u6570\u7EC4\u533A\u95F4\u548C",children:[]},{level:2,title:"2. \u6570\u7EC4\u4E2D\u7B49\u5DEE\u9012\u589E\u5B50\u533A\u95F4\u7684\u4E2A\u6570",slug:"_2-\u6570\u7EC4\u4E2D\u7B49\u5DEE\u9012\u589E\u5B50\u533A\u95F4\u7684\u4E2A\u6570",children:[]}]},{level:1,title:"\u5206\u5272\u6574\u6570",slug:"\u5206\u5272\u6574\u6570",children:[{level:2,title:"1. \u5206\u5272\u6574\u6570\u7684\u6700\u5927\u4E58\u79EF",slug:"_1-\u5206\u5272\u6574\u6570\u7684\u6700\u5927\u4E58\u79EF",children:[]},{level:2,title:"2. \u6309\u5E73\u65B9\u6570\u6765\u5206\u5272\u6574\u6570",slug:"_2-\u6309\u5E73\u65B9\u6570\u6765\u5206\u5272\u6574\u6570",children:[]},{level:2,title:"3. \u5206\u5272\u6574\u6570\u6784\u6210\u5B57\u6BCD\u5B57\u7B26\u4E32",slug:"_3-\u5206\u5272\u6574\u6570\u6784\u6210\u5B57\u6BCD\u5B57\u7B26\u4E32",children:[]}]},{level:1,title:"\u6700\u957F\u9012\u589E\u5B50\u5E8F\u5217",slug:"\u6700\u957F\u9012\u589E\u5B50\u5E8F\u5217",children:[{level:2,title:"1. \u6700\u957F\u9012\u589E\u5B50\u5E8F\u5217",slug:"_1-\u6700\u957F\u9012\u589E\u5B50\u5E8F\u5217",children:[]},{level:2,title:"2. \u4E00\u7EC4\u6574\u6570\u5BF9\u80FD\u591F\u6784\u6210\u7684\u6700\u957F\u94FE",slug:"_2-\u4E00\u7EC4\u6574\u6570\u5BF9\u80FD\u591F\u6784\u6210\u7684\u6700\u957F\u94FE",children:[]},{level:2,title:"3. \u6700\u957F\u6446\u52A8\u5B50\u5E8F\u5217",slug:"_3-\u6700\u957F\u6446\u52A8\u5B50\u5E8F\u5217",children:[]}]},{level:1,title:"\u6700\u957F\u516C\u5171\u5B50\u5E8F\u5217",slug:"\u6700\u957F\u516C\u5171\u5B50\u5E8F\u5217",children:[]},{level:1,title:"0-1 \u80CC\u5305",slug:"_0-1-\u80CC\u5305",children:[{level:2,title:"1. \u5212\u5206\u6570\u7EC4\u4E3A\u548C\u76F8\u7B49\u7684\u4E24\u90E8\u5206",slug:"_1-\u5212\u5206\u6570\u7EC4\u4E3A\u548C\u76F8\u7B49\u7684\u4E24\u90E8\u5206",children:[]},{level:2,title:"2. \u6539\u53D8\u4E00\u7EC4\u6570\u7684\u6B63\u8D1F\u53F7\u4F7F\u5F97\u5B83\u4EEC\u7684\u548C\u4E3A\u4E00\u7ED9\u5B9A\u6570",slug:"_2-\u6539\u53D8\u4E00\u7EC4\u6570\u7684\u6B63\u8D1F\u53F7\u4F7F\u5F97\u5B83\u4EEC\u7684\u548C\u4E3A\u4E00\u7ED9\u5B9A\u6570",children:[]},{level:2,title:"3. 01 \u5B57\u7B26\u6784\u6210\u6700\u591A\u7684\u5B57\u7B26\u4E32",slug:"_3-01-\u5B57\u7B26\u6784\u6210\u6700\u591A\u7684\u5B57\u7B26\u4E32",children:[]},{level:2,title:"4. \u627E\u96F6\u94B1\u7684\u6700\u5C11\u786C\u5E01\u6570",slug:"_4-\u627E\u96F6\u94B1\u7684\u6700\u5C11\u786C\u5E01\u6570",children:[]},{level:2,title:"5. \u627E\u96F6\u94B1\u7684\u786C\u5E01\u6570\u7EC4\u5408",slug:"_5-\u627E\u96F6\u94B1\u7684\u786C\u5E01\u6570\u7EC4\u5408",children:[]},{level:2,title:"6. \u5B57\u7B26\u4E32\u6309\u5355\u8BCD\u5217\u8868\u5206\u5272",slug:"_6-\u5B57\u7B26\u4E32\u6309\u5355\u8BCD\u5217\u8868\u5206\u5272",children:[]},{level:2,title:"7. \u7EC4\u5408\u603B\u548C",slug:"_7-\u7EC4\u5408\u603B\u548C",children:[]}]},{level:1,title:"\u80A1\u7968\u4EA4\u6613",slug:"\u80A1\u7968\u4EA4\u6613",children:[{level:2,title:"1. \u9700\u8981\u51B7\u5374\u671F\u7684\u80A1\u7968\u4EA4\u6613",slug:"_1-\u9700\u8981\u51B7\u5374\u671F\u7684\u80A1\u7968\u4EA4\u6613",children:[]},{level:2,title:"2. \u9700\u8981\u4EA4\u6613\u8D39\u7528\u7684\u80A1\u7968\u4EA4\u6613",slug:"_2-\u9700\u8981\u4EA4\u6613\u8D39\u7528\u7684\u80A1\u7968\u4EA4\u6613",children:[]},{level:2,title:"3. \u53EA\u80FD\u8FDB\u884C\u4E24\u6B21\u7684\u80A1\u7968\u4EA4\u6613",slug:"_3-\u53EA\u80FD\u8FDB\u884C\u4E24\u6B21\u7684\u80A1\u7968\u4EA4\u6613",children:[]},{level:2,title:"4. \u53EA\u80FD\u8FDB\u884C k \u6B21\u7684\u80A1\u7968\u4EA4\u6613",slug:"_4-\u53EA\u80FD\u8FDB\u884C-k-\u6B21\u7684\u80A1\u7968\u4EA4\u6613",children:[]}]},{level:1,title:"\u5B57\u7B26\u4E32\u7F16\u8F91",slug:"\u5B57\u7B26\u4E32\u7F16\u8F91",children:[{level:2,title:"1. \u5220\u9664\u4E24\u4E2A\u5B57\u7B26\u4E32\u7684\u5B57\u7B26\u4F7F\u5B83\u4EEC\u76F8\u7B49",slug:"_1-\u5220\u9664\u4E24\u4E2A\u5B57\u7B26\u4E32\u7684\u5B57\u7B26\u4F7F\u5B83\u4EEC\u76F8\u7B49",children:[]},{level:2,title:"2. \u7F16\u8F91\u8DDD\u79BB",slug:"_2-\u7F16\u8F91\u8DDD\u79BB",children:[]},{level:2,title:"3. \u590D\u5236\u7C98\u8D34\u5B57\u7B26",slug:"_3-\u590D\u5236\u7C98\u8D34\u5B57\u7B26",children:[]}]}],git:{createdTime:1652702879e3,updatedTime:1652702879e3,contributors:[{name:"chenwei.tjw",email:"chenwei.tjw@alibaba-inc.com",commits:1}]},readingTime:{minutes:27.76,words:8327},filePathRelative:"notes/\u7B97\u6CD5/Leetcode\u9898\u89E3-\u52A8\u6001\u89C4\u5212.md"};export{e as data};
