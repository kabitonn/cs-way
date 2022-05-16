const l={key:"v-db573028",path:"/notes/Java/Java%E5%B9%B6%E5%8F%91%E5%9F%BA%E7%A1%80.html",title:"\u4E00\u3001\u7EBF\u7A0B",lang:"zh-CN",frontmatter:{summary:"\u4E00\u3001\u7EBF\u7A0B; \u7EBF\u7A0B\u7B80\u4ECB; 1. \u4EC0\u4E48\u662F\u7EBF\u7A0B; 2. \u4E0A\u4E0B\u6587\u5207\u6362; 3. \u4F7F\u7528\u591A\u7EBF\u7A0B\u539F\u56E0; 4. \u5B88\u62A4\u7EBF\u7A0B; \u7EBF\u7A0B\u72B6\u6001; \u7EBF\u7A0B\u751F\u547D\u5468\u671F; \u7EBF\u7A0B\u7684\u4F7F\u7528; \u5B9E\u73B0 Runnable \u63A5\u53E3; \u5B9E\u73B0 Callable \u63A5\u53E3; \u7EE7\u627F Thread \u7C7B; \u5B9E\u73B0\u63A5\u53E3 VS \u7EE7\u627F Thread; \u7EBF\u7A0B\u95F4\u901A\u4FE1; synchronized; \u6761\u4EF6\u961F\u5217(wait/notify); \u663E\u5F0F",head:[["meta",{property:"og:url",content:"https://vuepress-theme-hope-v2-demo.mrhope.site/cs-way/notes/Java/Java%E5%B9%B6%E5%8F%91%E5%9F%BA%E7%A1%80.html"}],["meta",{property:"og:site_name",content:"CS Way"}],["meta",{property:"og:title",content:"\u4E00\u3001\u7EBF\u7A0B"}],["meta",{property:"og:type",content:"article"}],["meta",{property:"og:updated_time",content:"2022-05-16T12:07:59.000Z"}],["meta",{property:"og:locale",content:"zh-CN"}],["meta",{property:"article:modified_time",content:"2022-05-16T12:07:59.000Z"}]]},excerpt:"",headers:[{level:1,title:"\u4E00\u3001\u7EBF\u7A0B",slug:"\u4E00\u3001\u7EBF\u7A0B",children:[{level:2,title:"\u7EBF\u7A0B\u7B80\u4ECB",slug:"\u7EBF\u7A0B\u7B80\u4ECB",children:[{level:3,title:"1. \u4EC0\u4E48\u662F\u7EBF\u7A0B",slug:"_1-\u4EC0\u4E48\u662F\u7EBF\u7A0B",children:[]},{level:3,title:"2. \u4E0A\u4E0B\u6587\u5207\u6362",slug:"_2-\u4E0A\u4E0B\u6587\u5207\u6362",children:[]},{level:3,title:"3. \u4F7F\u7528\u591A\u7EBF\u7A0B\u539F\u56E0",slug:"_3-\u4F7F\u7528\u591A\u7EBF\u7A0B\u539F\u56E0",children:[]},{level:3,title:"4. \u5B88\u62A4\u7EBF\u7A0B",slug:"_4-\u5B88\u62A4\u7EBF\u7A0B",children:[]}]},{level:2,title:"\u7EBF\u7A0B\u72B6\u6001",slug:"\u7EBF\u7A0B\u72B6\u6001",children:[]},{level:2,title:"\u7EBF\u7A0B\u751F\u547D\u5468\u671F",slug:"\u7EBF\u7A0B\u751F\u547D\u5468\u671F",children:[]},{level:2,title:"\u7EBF\u7A0B\u7684\u4F7F\u7528",slug:"\u7EBF\u7A0B\u7684\u4F7F\u7528",children:[{level:3,title:"\u5B9E\u73B0 Runnable \u63A5\u53E3",slug:"\u5B9E\u73B0-runnable-\u63A5\u53E3",children:[]},{level:3,title:"\u5B9E\u73B0 Callable \u63A5\u53E3",slug:"\u5B9E\u73B0-callable-\u63A5\u53E3",children:[]},{level:3,title:"\u7EE7\u627F Thread \u7C7B",slug:"\u7EE7\u627F-thread-\u7C7B",children:[]},{level:3,title:"\u5B9E\u73B0\u63A5\u53E3 VS \u7EE7\u627F Thread",slug:"\u5B9E\u73B0\u63A5\u53E3-vs-\u7EE7\u627F-thread",children:[]}]},{level:2,title:"\u7EBF\u7A0B\u95F4\u901A\u4FE1",slug:"\u7EBF\u7A0B\u95F4\u901A\u4FE1",children:[{level:3,title:"synchronized",slug:"synchronized",children:[]},{level:3,title:"\u6761\u4EF6\u961F\u5217(wait/notify)",slug:"\u6761\u4EF6\u961F\u5217-wait-notify",children:[]},{level:3,title:"\u663E\u5F0FCondition\u5BF9\u8C61(await/signal)",slug:"\u663E\u5F0Fcondition\u5BF9\u8C61-await-signal",children:[]},{level:3,title:"join()",slug:"join",children:[]},{level:3,title:"ThreadLocal",slug:"threadlocal",children:[]}]}]},{level:1,title:"\u4E8C\u3001\u5E76\u53D1\u673A\u5236\u5E95\u5C42\u539F\u7406",slug:"\u4E8C\u3001\u5E76\u53D1\u673A\u5236\u5E95\u5C42\u539F\u7406",children:[{level:2,title:"volatile",slug:"volatile",children:[]},{level:2,title:"synchronized",slug:"synchronized-1",children:[{level:3,title:"1. Java\u5BF9\u8C61\u5934",slug:"_1-java\u5BF9\u8C61\u5934",children:[{level:4,title:"hashcode\uFF0C\u5206\u4EE3\u5E74\u9F84\u7B49\u4FE1\u606F",slug:"hashcode-\u5206\u4EE3\u5E74\u9F84\u7B49\u4FE1\u606F",children:[]}]},{level:3,title:"2. \u9501\u7684\u5347\u7EA7",slug:"_2-\u9501\u7684\u5347\u7EA7",children:[]},{level:3,title:"3. \u504F\u5411\u9501",slug:"_3-\u504F\u5411\u9501",children:[{level:4,title:"\u504F\u5411\u9501\u7684\u64A4\u9500",slug:"\u504F\u5411\u9501\u7684\u64A4\u9500",children:[]},{level:4,title:"\u504F\u5411\u9501\u7684\u5173\u95ED",slug:"\u504F\u5411\u9501\u7684\u5173\u95ED",children:[]}]},{level:3,title:"4. \u8F7B\u91CF\u7EA7\u9501",slug:"_4-\u8F7B\u91CF\u7EA7\u9501",children:[{level:4,title:"\u8F7B\u91CF\u7EA7\u9501\u52A0\u9501",slug:"\u8F7B\u91CF\u7EA7\u9501\u52A0\u9501",children:[]},{level:4,title:"\u8F7B\u91CF\u7EA7\u9501\u89E3\u9501",slug:"\u8F7B\u91CF\u7EA7\u9501\u89E3\u9501",children:[]}]},{level:3,title:"5. \u9501\u7684\u5BF9\u6BD4",slug:"_5-\u9501\u7684\u5BF9\u6BD4",children:[]},{level:3,title:"6. synchronized \u5BF9\u6BD4 volatile",slug:"_6-synchronized-\u5BF9\u6BD4-volatile",children:[]}]},{level:2,title:"\u539F\u5B50\u64CD\u4F5C\u7684\u5B9E\u73B0",slug:"\u539F\u5B50\u64CD\u4F5C\u7684\u5B9E\u73B0",children:[{level:3,title:"\u5904\u7406\u5668\u5B9E\u73B0\u539F\u5B50\u64CD\u4F5C",slug:"\u5904\u7406\u5668\u5B9E\u73B0\u539F\u5B50\u64CD\u4F5C",children:[]},{level:3,title:"Java\u5B9E\u73B0\u539F\u5B50\u64CD\u4F5C",slug:"java\u5B9E\u73B0\u539F\u5B50\u64CD\u4F5C",children:[]}]}]},{level:1,title:"\u4E09\u3001\u7EBF\u7A0B\u5B89\u5168\u4E0E\u9501\u4F18\u5316",slug:"\u4E09\u3001\u7EBF\u7A0B\u5B89\u5168\u4E0E\u9501\u4F18\u5316",children:[{level:2,title:"\u7EBF\u7A0B\u5B89\u5168",slug:"\u7EBF\u7A0B\u5B89\u5168",children:[{level:3,title:"Java\u8BED\u8A00\u4E2D\u7684\u7EBF\u7A0B\u5B89\u5168",slug:"java\u8BED\u8A00\u4E2D\u7684\u7EBF\u7A0B\u5B89\u5168",children:[]},{level:3,title:"\u7EBF\u7A0B\u5B89\u5168\u7684\u5B9E\u73B0\u65B9\u6CD5",slug:"\u7EBF\u7A0B\u5B89\u5168\u7684\u5B9E\u73B0\u65B9\u6CD5",children:[{level:4,title:"\u4E92\u65A5\u540C\u6B65",slug:"\u4E92\u65A5\u540C\u6B65",children:[]},{level:4,title:"\u975E\u963B\u585E\u540C\u6B65",slug:"\u975E\u963B\u585E\u540C\u6B65",children:[]},{level:4,title:"\u65E0\u540C\u6B65\u65B9\u6848",slug:"\u65E0\u540C\u6B65\u65B9\u6848",children:[]}]}]},{level:2,title:"\u9501\u4F18\u5316",slug:"\u9501\u4F18\u5316",children:[{level:3,title:"\u81EA\u65CB\u9501",slug:"\u81EA\u65CB\u9501",children:[]},{level:3,title:"\u9501\u6D88\u9664",slug:"\u9501\u6D88\u9664",children:[]},{level:3,title:"\u9501\u7C97\u5316",slug:"\u9501\u7C97\u5316",children:[]}]}]},{level:1,title:"\u56DB\u3001Java\u5185\u5B58\u6A21\u578B",slug:"\u56DB\u3001java\u5185\u5B58\u6A21\u578B",children:[{level:2,title:"\u4E3B\u5185\u5B58\u4E0E\u5DE5\u4F5C\u5185\u5B58",slug:"\u4E3B\u5185\u5B58\u4E0E\u5DE5\u4F5C\u5185\u5B58",children:[]},{level:2,title:"\u5185\u5B58\u95F4\u4EA4\u4E92\u64CD\u4F5C",slug:"\u5185\u5B58\u95F4\u4EA4\u4E92\u64CD\u4F5C",children:[]},{level:2,title:"\u5185\u5B58\u6A21\u578B\u4E09\u5927\u7279\u6027",slug:"\u5185\u5B58\u6A21\u578B\u4E09\u5927\u7279\u6027",children:[{level:3,title:"1. \u539F\u5B50\u6027",slug:"_1-\u539F\u5B50\u6027",children:[]},{level:3,title:"2. \u53EF\u89C1\u6027",slug:"_2-\u53EF\u89C1\u6027",children:[{level:4,title:"synchronized\u5173\u952E\u5B57\u548Cvolatile\u5173\u952E\u5B57\u6BD4\u8F83",slug:"synchronized\u5173\u952E\u5B57\u548Cvolatile\u5173\u952E\u5B57\u6BD4\u8F83",children:[]}]},{level:3,title:"3. \u6709\u5E8F\u6027",slug:"_3-\u6709\u5E8F\u6027",children:[]}]},{level:2,title:"\u5148\u884C\u53D1\u751F(happens-before)\u539F\u5219",slug:"\u5148\u884C\u53D1\u751F-happens-before-\u539F\u5219",children:[{level:3,title:"1. \u5355\u4E00\u7EBF\u7A0B\u539F\u5219",slug:"_1-\u5355\u4E00\u7EBF\u7A0B\u539F\u5219",children:[]},{level:3,title:"2. \u7BA1\u7A0B\u9501\u5B9A\u89C4\u5219",slug:"_2-\u7BA1\u7A0B\u9501\u5B9A\u89C4\u5219",children:[]},{level:3,title:"3. volatile \u53D8\u91CF\u89C4\u5219",slug:"_3-volatile-\u53D8\u91CF\u89C4\u5219",children:[]},{level:3,title:"4. \u7EBF\u7A0B\u542F\u52A8\u89C4\u5219",slug:"_4-\u7EBF\u7A0B\u542F\u52A8\u89C4\u5219",children:[]},{level:3,title:"5. \u7EBF\u7A0B\u52A0\u5165\u89C4\u5219",slug:"_5-\u7EBF\u7A0B\u52A0\u5165\u89C4\u5219",children:[]},{level:3,title:"6. \u7EBF\u7A0B\u4E2D\u65AD\u89C4\u5219",slug:"_6-\u7EBF\u7A0B\u4E2D\u65AD\u89C4\u5219",children:[]},{level:3,title:"7. \u5BF9\u8C61\u7EC8\u7ED3\u89C4\u5219",slug:"_7-\u5BF9\u8C61\u7EC8\u7ED3\u89C4\u5219",children:[]},{level:3,title:"8. \u4F20\u9012\u6027",slug:"_8-\u4F20\u9012\u6027",children:[]}]},{level:2,title:"\u6307\u4EE4\u91CD\u6392\u5E8F",slug:"\u6307\u4EE4\u91CD\u6392\u5E8F",children:[{level:3,title:"\u5185\u5B58\u5C4F\u969C",slug:"\u5185\u5B58\u5C4F\u969C",children:[]},{level:3,title:"\u6570\u636E\u4F9D\u8D56\u6027",slug:"\u6570\u636E\u4F9D\u8D56\u6027",children:[]},{level:3,title:"as-if-serial\u8BED\u4E49",slug:"as-if-serial\u8BED\u4E49",children:[]},{level:3,title:"\u987A\u5E8F\u4E00\u81F4\u6027",slug:"\u987A\u5E8F\u4E00\u81F4\u6027",children:[]}]},{level:2,title:"\u5185\u5B58\u8BED\u4E49",slug:"\u5185\u5B58\u8BED\u4E49",children:[{level:3,title:"volatile\u5185\u5B58\u8BED\u4E49",slug:"volatile\u5185\u5B58\u8BED\u4E49",children:[{level:4,title:"volatile\u5185\u5B58\u8BED\u4E49\u7684\u5B9E\u73B0",slug:"volatile\u5185\u5B58\u8BED\u4E49\u7684\u5B9E\u73B0",children:[]}]},{level:3,title:"\u9501\u7684\u5185\u5B58\u8BED\u4E49",slug:"\u9501\u7684\u5185\u5B58\u8BED\u4E49",children:[{level:4,title:"\u9501\u5185\u5B58\u8BED\u4E49\u7684\u5B9E\u73B0",slug:"\u9501\u5185\u5B58\u8BED\u4E49\u7684\u5B9E\u73B0",children:[]},{level:4,title:"concurrent\u5305\u7684\u5B9E\u73B0",slug:"concurrent\u5305\u7684\u5B9E\u73B0",children:[]}]},{level:3,title:"final\u5185\u5B58\u8BED\u4E49",slug:"final\u5185\u5B58\u8BED\u4E49",children:[{level:4,title:"final\u57DF\u7684\u91CD\u6392\u5E8F\u89C4\u5219",slug:"final\u57DF\u7684\u91CD\u6392\u5E8F\u89C4\u5219",children:[]},{level:4,title:"\u5199final\u57DF\u7684\u91CD\u6392\u5E8F\u89C4\u5219",slug:"\u5199final\u57DF\u7684\u91CD\u6392\u5E8F\u89C4\u5219",children:[]},{level:4,title:"\u8BFBfinal\u57DF\u7684\u91CD\u6392\u5E8F\u89C4\u5219",slug:"\u8BFBfinal\u57DF\u7684\u91CD\u6392\u5E8F\u89C4\u5219",children:[]}]}]}]},{level:1,title:"\u4E94\u3001Java\u4E2D\u7684\u9501",slug:"\u4E94\u3001java\u4E2D\u7684\u9501",children:[{level:2,title:"Lock\u63A5\u53E3",slug:"lock\u63A5\u53E3",children:[]},{level:2,title:"\u961F\u5217\u540C\u6B65\u5668",slug:"\u961F\u5217\u540C\u6B65\u5668",children:[{level:3,title:"\u961F\u5217\u540C\u6B65\u5668\u7684\u5B9E\u73B0",slug:"\u961F\u5217\u540C\u6B65\u5668\u7684\u5B9E\u73B0",children:[]}]},{level:2,title:"\u91CD\u5165\u9501",slug:"\u91CD\u5165\u9501",children:[{level:3,title:"ReentrantLock \u5BF9\u6BD4 synchronized",slug:"reentrantlock-\u5BF9\u6BD4-synchronized",children:[]}]},{level:2,title:"\u8BFB\u5199\u9501",slug:"\u8BFB\u5199\u9501",children:[]},{level:2,title:"LockSupport\u5DE5\u5177",slug:"locksupport\u5DE5\u5177",children:[]},{level:2,title:"Condition\u63A5\u53E3",slug:"condition\u63A5\u53E3",children:[]}]},{level:1,title:"\u516D\u3001Java\u4E2D\u7684\u5E76\u53D1\u5DE5\u5177\u7C7B",slug:"\u516D\u3001java\u4E2D\u7684\u5E76\u53D1\u5DE5\u5177\u7C7B",children:[{level:2,title:"CountDownLatch",slug:"countdownlatch",children:[]},{level:2,title:"CyclicBarrier",slug:"cyclicbarrier",children:[]},{level:2,title:"Semaphore",slug:"semaphore",children:[]},{level:2,title:"Exchanger",slug:"exchanger",children:[]}]},{level:1,title:"\u4E03\u3001Java\u4E2D\u539F\u5B50\u64CD\u4F5C\u7C7B",slug:"\u4E03\u3001java\u4E2D\u539F\u5B50\u64CD\u4F5C\u7C7B",children:[{level:2,title:"\u539F\u5B50\u66F4\u65B0\u57FA\u672C\u7C7B\u578B",slug:"\u539F\u5B50\u66F4\u65B0\u57FA\u672C\u7C7B\u578B",children:[]},{level:2,title:"\u539F\u5B50\u66F4\u65B0\u6570\u7EC4",slug:"\u539F\u5B50\u66F4\u65B0\u6570\u7EC4",children:[]},{level:2,title:"\u539F\u5B50\u66F4\u65B0\u5F15\u7528\u7C7B\u578B",slug:"\u539F\u5B50\u66F4\u65B0\u5F15\u7528\u7C7B\u578B",children:[]},{level:2,title:"\u539F\u5B50\u66F4\u65B0\u5B57\u6BB5\u7C7B",slug:"\u539F\u5B50\u66F4\u65B0\u5B57\u6BB5\u7C7B",children:[]}]},{level:1,title:"\u53C2\u8003\u8D44\u6599",slug:"\u53C2\u8003\u8D44\u6599",children:[]}],git:{createdTime:1652702879e3,updatedTime:1652702879e3,contributors:[{name:"chenwei.tjw",email:"chenwei.tjw@alibaba-inc.com",commits:1}]},readingTime:{minutes:88.49,words:26548},filePathRelative:"notes/Java/Java\u5E76\u53D1\u57FA\u7840.md"};export{l as data};
