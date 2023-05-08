const e={key:"v-90c5eb2a",path:"/notes/Java/JavaIO.html",title:"JavaIO",lang:"zh-CN",frontmatter:{title:"JavaIO",icon:null,category:["Java"],tag:["IO","NIO"],summary:"\u4E00\u3001\u6982\u89C8; \u5206\u7C7B\u8BF4\u660E; \u64CD\u4F5C\u65B9\u5F0F\u5206\u7C7B\u7ED3\u6784; \u64CD\u4F5C\u5BF9\u8C61\u5206\u7C7B\u7ED3\u6784; \u5176\u4ED6\u7C7B; \u4E8C\u3001\u78C1\u76D8\u64CD\u4F5C; File; Path; Files; \u4E09\u3001\u5B57\u8282\u64CD\u4F5C; \u5B9E\u73B0\u6587\u4EF6\u590D\u5236; \u88C5\u9970\u8005\u6A21\u5F0F; \u56DB\u3001\u5B57\u7B26\u64CD\u4F5C; \u7F16\u7801\u4E0E\u89E3\u7801; String \u7684\u7F16\u7801\u65B9\u5F0F; Reader \u4E0E Writer; \u5B9E\u73B0\u9010\u884C\u8F93\u51FA\u6587\u672C\u6587\u4EF6\u7684\u5185\u5BB9; \u4E94\u3001\u5BF9\u8C61\u64CD\u4F5C; \u5E8F\u5217\u5316; Serializable; trans",head:[["meta",{property:"og:url",content:"https://vuepress-theme-hope-v2-demo.mrhope.site/cs-way/notes/Java/JavaIO.html"}],["meta",{property:"og:site_name",content:"CS Way"}],["meta",{property:"og:title",content:"JavaIO"}],["meta",{property:"og:type",content:"article"}],["meta",{property:"og:updated_time",content:"2022-05-17T12:22:19.000Z"}],["meta",{property:"og:locale",content:"zh-CN"}],["meta",{property:"article:tag",content:"IO"}],["meta",{property:"article:tag",content:"NIO"}],["meta",{property:"article:modified_time",content:"2022-05-17T12:22:19.000Z"}]]},excerpt:"",headers:[{level:1,title:"\u4E00\u3001\u6982\u89C8",slug:"\u4E00\u3001\u6982\u89C8",children:[{level:2,title:"\u5206\u7C7B\u8BF4\u660E",slug:"\u5206\u7C7B\u8BF4\u660E",children:[{level:3,title:"\u64CD\u4F5C\u65B9\u5F0F\u5206\u7C7B\u7ED3\u6784",slug:"\u64CD\u4F5C\u65B9\u5F0F\u5206\u7C7B\u7ED3\u6784",children:[]},{level:3,title:"\u64CD\u4F5C\u5BF9\u8C61\u5206\u7C7B\u7ED3\u6784",slug:"\u64CD\u4F5C\u5BF9\u8C61\u5206\u7C7B\u7ED3\u6784",children:[]},{level:3,title:"\u5176\u4ED6\u7C7B",slug:"\u5176\u4ED6\u7C7B",children:[]}]}]},{level:1,title:"\u4E8C\u3001\u78C1\u76D8\u64CD\u4F5C",slug:"\u4E8C\u3001\u78C1\u76D8\u64CD\u4F5C",children:[{level:2,title:"File",slug:"file",children:[]},{level:2,title:"Path",slug:"path",children:[]},{level:2,title:"Files",slug:"files",children:[]}]},{level:1,title:"\u4E09\u3001\u5B57\u8282\u64CD\u4F5C",slug:"\u4E09\u3001\u5B57\u8282\u64CD\u4F5C",children:[{level:2,title:"\u5B9E\u73B0\u6587\u4EF6\u590D\u5236",slug:"\u5B9E\u73B0\u6587\u4EF6\u590D\u5236",children:[]},{level:2,title:"\u88C5\u9970\u8005\u6A21\u5F0F",slug:"\u88C5\u9970\u8005\u6A21\u5F0F",children:[]}]},{level:1,title:"\u56DB\u3001\u5B57\u7B26\u64CD\u4F5C",slug:"\u56DB\u3001\u5B57\u7B26\u64CD\u4F5C",children:[{level:2,title:"\u7F16\u7801\u4E0E\u89E3\u7801",slug:"\u7F16\u7801\u4E0E\u89E3\u7801",children:[]},{level:2,title:"String \u7684\u7F16\u7801\u65B9\u5F0F",slug:"string-\u7684\u7F16\u7801\u65B9\u5F0F",children:[]},{level:2,title:"Reader \u4E0E Writer",slug:"reader-\u4E0E-writer",children:[]},{level:2,title:"\u5B9E\u73B0\u9010\u884C\u8F93\u51FA\u6587\u672C\u6587\u4EF6\u7684\u5185\u5BB9",slug:"\u5B9E\u73B0\u9010\u884C\u8F93\u51FA\u6587\u672C\u6587\u4EF6\u7684\u5185\u5BB9",children:[]}]},{level:1,title:"\u4E94\u3001\u5BF9\u8C61\u64CD\u4F5C",slug:"\u4E94\u3001\u5BF9\u8C61\u64CD\u4F5C",children:[{level:2,title:"\u5E8F\u5217\u5316",slug:"\u5E8F\u5217\u5316",children:[]},{level:2,title:"Serializable",slug:"serializable",children:[]},{level:2,title:"transient",slug:"transient",children:[]}]},{level:1,title:"\u516D\u3001\u7F51\u7EDC\u64CD\u4F5C",slug:"\u516D\u3001\u7F51\u7EDC\u64CD\u4F5C",children:[{level:2,title:"InetAddress",slug:"inetaddress",children:[]},{level:2,title:"URL",slug:"url",children:[]},{level:2,title:"Sockets",slug:"sockets",children:[]},{level:2,title:"Datagram",slug:"datagram",children:[]}]},{level:1,title:"\u4E03\u3001NIO",slug:"\u4E03\u3001nio",children:[{level:2,title:"\u6D41\u4E0E\u5757",slug:"\u6D41\u4E0E\u5757",children:[]},{level:2,title:"\u901A\u9053",slug:"\u901A\u9053",children:[]},{level:2,title:"\u7F13\u51B2\u533A",slug:"\u7F13\u51B2\u533A",children:[{level:3,title:"\u7F13\u51B2\u533A\u72B6\u6001\u53D8\u91CF",slug:"\u7F13\u51B2\u533A\u72B6\u6001\u53D8\u91CF",children:[]}]},{level:2,title:"\u9009\u62E9\u5668",slug:"\u9009\u62E9\u5668",children:[{level:3,title:"1. \u521B\u5EFA\u9009\u62E9\u5668",slug:"_1-\u521B\u5EFA\u9009\u62E9\u5668",children:[]},{level:3,title:"2. \u5C06\u901A\u9053\u6CE8\u518C\u5230\u9009\u62E9\u5668\u4E0A",slug:"_2-\u5C06\u901A\u9053\u6CE8\u518C\u5230\u9009\u62E9\u5668\u4E0A",children:[]},{level:3,title:"3. \u76D1\u542C\u4E8B\u4EF6",slug:"_3-\u76D1\u542C\u4E8B\u4EF6",children:[]},{level:3,title:"4. \u83B7\u53D6\u5230\u8FBE\u7684\u4E8B\u4EF6",slug:"_4-\u83B7\u53D6\u5230\u8FBE\u7684\u4E8B\u4EF6",children:[]},{level:3,title:"5. \u4E8B\u4EF6\u5FAA\u73AF",slug:"_5-\u4E8B\u4EF6\u5FAA\u73AF",children:[]}]},{level:2,title:"\u6587\u4EF6 NIO \u5B9E\u4F8B",slug:"\u6587\u4EF6-nio-\u5B9E\u4F8B",children:[]},{level:2,title:"\u5957\u63A5\u5B57 NIO \u5B9E\u4F8B",slug:"\u5957\u63A5\u5B57-nio-\u5B9E\u4F8B",children:[]},{level:2,title:"\u5176\u4ED6\u5B9E\u4F8B",slug:"\u5176\u4ED6\u5B9E\u4F8B",children:[]},{level:2,title:"Scatter / Gather",slug:"scatter-gather",children:[]},{level:2,title:"\u5185\u5B58\u6620\u5C04\u6587\u4EF6",slug:"\u5185\u5B58\u6620\u5C04\u6587\u4EF6",children:[]}]},{level:1,title:"BIO,NIO,AIO",slug:"bio-nio-aio",children:[{level:2,title:"BIO(Blocking I/O)",slug:"bio-blocking-i-o",children:[]},{level:2,title:"NIO(Non-blocking I/O)",slug:"nio-non-blocking-i-o",children:[]},{level:2,title:"AIO(Asynchronous I/O)",slug:"aio-asynchronous-i-o",children:[]}]},{level:1,title:"\u516B\u3001\u53C2\u8003\u8D44\u6599",slug:"\u516B\u3001\u53C2\u8003\u8D44\u6599",children:[]}],git:{createdTime:1652702879e3,updatedTime:1652790139e3,contributors:[{name:"chenwei.tjw",email:"chenwei.tjw@alibaba-inc.com",commits:2}]},readingTime:{minutes:31.65,words:9494},filePathRelative:"notes/Java/JavaIO.md"};export{e as data};