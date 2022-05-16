import{_ as n}from"./plugin-vue_export-helper.21dcd24c.js";import{f as s}from"./app.7d4bd0aa.js";const a={},p=s(`<ul><li><a href="#%E6%A0%88">\u6808</a><ul><li><a href="#1-%E6%95%B0%E7%BB%84%E5%AE%9E%E7%8E%B0">1. \u6570\u7EC4\u5B9E\u73B0</a></li><li><a href="#2-%E9%93%BE%E8%A1%A8%E5%AE%9E%E7%8E%B0">2. \u94FE\u8868\u5B9E\u73B0</a></li></ul></li><li><a href="#%E9%98%9F%E5%88%97">\u961F\u5217</a></li></ul><h1 id="\u6808" tabindex="-1"><a class="header-anchor" href="#\u6808" aria-hidden="true">#</a> \u6808</h1><div class="language-java ext-java line-numbers-mode"><pre class="language-java"><code><span class="token keyword">public</span> <span class="token keyword">interface</span> <span class="token class-name">MyStack</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">Item</span><span class="token punctuation">&gt;</span></span> <span class="token keyword">extends</span> <span class="token class-name">Iterable</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">Item</span><span class="token punctuation">&gt;</span></span> <span class="token punctuation">{</span>

    <span class="token class-name">MyStack</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">Item</span><span class="token punctuation">&gt;</span></span> <span class="token function">push</span><span class="token punctuation">(</span><span class="token class-name">Item</span> item<span class="token punctuation">)</span><span class="token punctuation">;</span>

    <span class="token class-name">Item</span> <span class="token function">pop</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token keyword">throws</span> <span class="token class-name">Exception</span><span class="token punctuation">;</span>

    <span class="token keyword">boolean</span> <span class="token function">isEmpty</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>

    <span class="token keyword">int</span> <span class="token function">size</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>

<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><span class="line-number">1</span><br><span class="line-number">2</span><br><span class="line-number">3</span><br><span class="line-number">4</span><br><span class="line-number">5</span><br><span class="line-number">6</span><br><span class="line-number">7</span><br><span class="line-number">8</span><br><span class="line-number">9</span><br><span class="line-number">10</span><br><span class="line-number">11</span><br></div></div><h2 id="_1-\u6570\u7EC4\u5B9E\u73B0" tabindex="-1"><a class="header-anchor" href="#_1-\u6570\u7EC4\u5B9E\u73B0" aria-hidden="true">#</a> 1. \u6570\u7EC4\u5B9E\u73B0</h2><div class="language-java ext-java line-numbers-mode"><pre class="language-java"><code><span class="token keyword">public</span> <span class="token keyword">class</span> <span class="token class-name">ArrayStack</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">Item</span><span class="token punctuation">&gt;</span></span> <span class="token keyword">implements</span> <span class="token class-name">MyStack</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">Item</span><span class="token punctuation">&gt;</span></span> <span class="token punctuation">{</span>

    <span class="token comment">// \u6808\u5143\u7D20\u6570\u7EC4\uFF0C\u53EA\u80FD\u901A\u8FC7\u8F6C\u578B\u6765\u521B\u5EFA\u6CDB\u578B\u6570\u7EC4</span>
    <span class="token keyword">private</span> <span class="token class-name">Item</span><span class="token punctuation">[</span><span class="token punctuation">]</span> a <span class="token operator">=</span> <span class="token punctuation">(</span><span class="token class-name">Item</span><span class="token punctuation">[</span><span class="token punctuation">]</span><span class="token punctuation">)</span> <span class="token keyword">new</span> <span class="token class-name">Object</span><span class="token punctuation">[</span><span class="token number">1</span><span class="token punctuation">]</span><span class="token punctuation">;</span>

    <span class="token comment">// \u5143\u7D20\u6570\u91CF</span>
    <span class="token keyword">private</span> <span class="token keyword">int</span> <span class="token class-name">N</span> <span class="token operator">=</span> <span class="token number">0</span><span class="token punctuation">;</span>


    <span class="token annotation punctuation">@Override</span>
    <span class="token keyword">public</span> <span class="token class-name">MyStack</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">Item</span><span class="token punctuation">&gt;</span></span> <span class="token function">push</span><span class="token punctuation">(</span><span class="token class-name">Item</span> item<span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token function">check</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        a<span class="token punctuation">[</span><span class="token class-name">N</span><span class="token operator">++</span><span class="token punctuation">]</span> <span class="token operator">=</span> item<span class="token punctuation">;</span>
        <span class="token keyword">return</span> <span class="token keyword">this</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>


    <span class="token annotation punctuation">@Override</span>
    <span class="token keyword">public</span> <span class="token class-name">Item</span> <span class="token function">pop</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token keyword">throws</span> <span class="token class-name">Exception</span> <span class="token punctuation">{</span>

        <span class="token keyword">if</span> <span class="token punctuation">(</span><span class="token function">isEmpty</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
            <span class="token keyword">throw</span> <span class="token keyword">new</span> <span class="token class-name">Exception</span><span class="token punctuation">(</span><span class="token string">&quot;stack is empty&quot;</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token punctuation">}</span>

        <span class="token class-name">Item</span> item <span class="token operator">=</span> a<span class="token punctuation">[</span><span class="token operator">--</span><span class="token class-name">N</span><span class="token punctuation">]</span><span class="token punctuation">;</span>

        <span class="token function">check</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>

        <span class="token comment">// \u907F\u514D\u5BF9\u8C61\u6E38\u79BB</span>
        a<span class="token punctuation">[</span><span class="token class-name">N</span><span class="token punctuation">]</span> <span class="token operator">=</span> <span class="token keyword">null</span><span class="token punctuation">;</span>

        <span class="token keyword">return</span> item<span class="token punctuation">;</span>
    <span class="token punctuation">}</span>


    <span class="token keyword">private</span> <span class="token keyword">void</span> <span class="token function">check</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>

        <span class="token keyword">if</span> <span class="token punctuation">(</span><span class="token class-name">N</span> <span class="token operator">&gt;=</span> a<span class="token punctuation">.</span>length<span class="token punctuation">)</span> <span class="token punctuation">{</span>
            <span class="token function">resize</span><span class="token punctuation">(</span><span class="token number">2</span> <span class="token operator">*</span> a<span class="token punctuation">.</span>length<span class="token punctuation">)</span><span class="token punctuation">;</span>

        <span class="token punctuation">}</span> <span class="token keyword">else</span> <span class="token keyword">if</span> <span class="token punctuation">(</span><span class="token class-name">N</span> <span class="token operator">&gt;</span> <span class="token number">0</span> <span class="token operator">&amp;&amp;</span> <span class="token class-name">N</span> <span class="token operator">&lt;=</span> a<span class="token punctuation">.</span>length <span class="token operator">/</span> <span class="token number">4</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
            <span class="token function">resize</span><span class="token punctuation">(</span>a<span class="token punctuation">.</span>length <span class="token operator">/</span> <span class="token number">2</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token punctuation">}</span>
    <span class="token punctuation">}</span>


    <span class="token doc-comment comment">/**
     * \u8C03\u6574\u6570\u7EC4\u5927\u5C0F\uFF0C\u4F7F\u5F97\u6808\u5177\u6709\u4F38\u7F29\u6027
     */</span>
    <span class="token keyword">private</span> <span class="token keyword">void</span> <span class="token function">resize</span><span class="token punctuation">(</span><span class="token keyword">int</span> size<span class="token punctuation">)</span> <span class="token punctuation">{</span>

        <span class="token class-name">Item</span><span class="token punctuation">[</span><span class="token punctuation">]</span> tmp <span class="token operator">=</span> <span class="token punctuation">(</span><span class="token class-name">Item</span><span class="token punctuation">[</span><span class="token punctuation">]</span><span class="token punctuation">)</span> <span class="token keyword">new</span> <span class="token class-name">Object</span><span class="token punctuation">[</span>size<span class="token punctuation">]</span><span class="token punctuation">;</span>

        <span class="token keyword">for</span> <span class="token punctuation">(</span><span class="token keyword">int</span> i <span class="token operator">=</span> <span class="token number">0</span><span class="token punctuation">;</span> i <span class="token operator">&lt;</span> <span class="token class-name">N</span><span class="token punctuation">;</span> i<span class="token operator">++</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
            tmp<span class="token punctuation">[</span>i<span class="token punctuation">]</span> <span class="token operator">=</span> a<span class="token punctuation">[</span>i<span class="token punctuation">]</span><span class="token punctuation">;</span>
        <span class="token punctuation">}</span>

        a <span class="token operator">=</span> tmp<span class="token punctuation">;</span>
    <span class="token punctuation">}</span>


    <span class="token annotation punctuation">@Override</span>
    <span class="token keyword">public</span> <span class="token keyword">boolean</span> <span class="token function">isEmpty</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token keyword">return</span> <span class="token class-name">N</span> <span class="token operator">==</span> <span class="token number">0</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>


    <span class="token annotation punctuation">@Override</span>
    <span class="token keyword">public</span> <span class="token keyword">int</span> <span class="token function">size</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token keyword">return</span> <span class="token class-name">N</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>


    <span class="token annotation punctuation">@Override</span>
    <span class="token keyword">public</span> <span class="token class-name">Iterator</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">Item</span><span class="token punctuation">&gt;</span></span> <span class="token function">iterator</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>

        <span class="token comment">// \u8FD4\u56DE\u9006\u5E8F\u904D\u5386\u7684\u8FED\u4EE3\u5668</span>
        <span class="token keyword">return</span> <span class="token keyword">new</span> <span class="token class-name">Iterator</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">Item</span><span class="token punctuation">&gt;</span></span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>

            <span class="token keyword">private</span> <span class="token keyword">int</span> i <span class="token operator">=</span> <span class="token class-name">N</span><span class="token punctuation">;</span>

            <span class="token annotation punctuation">@Override</span>
            <span class="token keyword">public</span> <span class="token keyword">boolean</span> <span class="token function">hasNext</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
                <span class="token keyword">return</span> i <span class="token operator">&gt;</span> <span class="token number">0</span><span class="token punctuation">;</span>
            <span class="token punctuation">}</span>

            <span class="token annotation punctuation">@Override</span>
            <span class="token keyword">public</span> <span class="token class-name">Item</span> <span class="token function">next</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
                <span class="token keyword">return</span> a<span class="token punctuation">[</span><span class="token operator">--</span>i<span class="token punctuation">]</span><span class="token punctuation">;</span>
            <span class="token punctuation">}</span>
        <span class="token punctuation">}</span><span class="token punctuation">;</span>

    <span class="token punctuation">}</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><span class="line-number">1</span><br><span class="line-number">2</span><br><span class="line-number">3</span><br><span class="line-number">4</span><br><span class="line-number">5</span><br><span class="line-number">6</span><br><span class="line-number">7</span><br><span class="line-number">8</span><br><span class="line-number">9</span><br><span class="line-number">10</span><br><span class="line-number">11</span><br><span class="line-number">12</span><br><span class="line-number">13</span><br><span class="line-number">14</span><br><span class="line-number">15</span><br><span class="line-number">16</span><br><span class="line-number">17</span><br><span class="line-number">18</span><br><span class="line-number">19</span><br><span class="line-number">20</span><br><span class="line-number">21</span><br><span class="line-number">22</span><br><span class="line-number">23</span><br><span class="line-number">24</span><br><span class="line-number">25</span><br><span class="line-number">26</span><br><span class="line-number">27</span><br><span class="line-number">28</span><br><span class="line-number">29</span><br><span class="line-number">30</span><br><span class="line-number">31</span><br><span class="line-number">32</span><br><span class="line-number">33</span><br><span class="line-number">34</span><br><span class="line-number">35</span><br><span class="line-number">36</span><br><span class="line-number">37</span><br><span class="line-number">38</span><br><span class="line-number">39</span><br><span class="line-number">40</span><br><span class="line-number">41</span><br><span class="line-number">42</span><br><span class="line-number">43</span><br><span class="line-number">44</span><br><span class="line-number">45</span><br><span class="line-number">46</span><br><span class="line-number">47</span><br><span class="line-number">48</span><br><span class="line-number">49</span><br><span class="line-number">50</span><br><span class="line-number">51</span><br><span class="line-number">52</span><br><span class="line-number">53</span><br><span class="line-number">54</span><br><span class="line-number">55</span><br><span class="line-number">56</span><br><span class="line-number">57</span><br><span class="line-number">58</span><br><span class="line-number">59</span><br><span class="line-number">60</span><br><span class="line-number">61</span><br><span class="line-number">62</span><br><span class="line-number">63</span><br><span class="line-number">64</span><br><span class="line-number">65</span><br><span class="line-number">66</span><br><span class="line-number">67</span><br><span class="line-number">68</span><br><span class="line-number">69</span><br><span class="line-number">70</span><br><span class="line-number">71</span><br><span class="line-number">72</span><br><span class="line-number">73</span><br><span class="line-number">74</span><br><span class="line-number">75</span><br><span class="line-number">76</span><br><span class="line-number">77</span><br><span class="line-number">78</span><br><span class="line-number">79</span><br><span class="line-number">80</span><br><span class="line-number">81</span><br><span class="line-number">82</span><br><span class="line-number">83</span><br><span class="line-number">84</span><br><span class="line-number">85</span><br><span class="line-number">86</span><br><span class="line-number">87</span><br><span class="line-number">88</span><br><span class="line-number">89</span><br><span class="line-number">90</span><br><span class="line-number">91</span><br><span class="line-number">92</span><br><span class="line-number">93</span><br><span class="line-number">94</span><br></div></div><h2 id="_2-\u94FE\u8868\u5B9E\u73B0" tabindex="-1"><a class="header-anchor" href="#_2-\u94FE\u8868\u5B9E\u73B0" aria-hidden="true">#</a> 2. \u94FE\u8868\u5B9E\u73B0</h2><p>\u9700\u8981\u4F7F\u7528\u94FE\u8868\u7684\u5934\u63D2\u6CD5\u6765\u5B9E\u73B0\uFF0C\u56E0\u4E3A\u5934\u63D2\u6CD5\u4E2D\u6700\u540E\u538B\u5165\u6808\u7684\u5143\u7D20\u5728\u94FE\u8868\u7684\u5F00\u5934\uFF0C\u5B83\u7684 next \u6307\u9488\u6307\u5411\u524D\u4E00\u4E2A\u538B\u5165\u6808\u7684\u5143\u7D20\uFF0C\u5728\u5F39\u51FA\u5143\u7D20\u65F6\u5C31\u53EF\u4EE5\u901A\u8FC7 next \u6307\u9488\u904D\u5386\u5230\u524D\u4E00\u4E2A\u538B\u5165\u6808\u7684\u5143\u7D20\u4ECE\u800C\u8BA9\u8FD9\u4E2A\u5143\u7D20\u6210\u4E3A\u65B0\u7684\u6808\u9876\u5143\u7D20\u3002</p><div class="language-java ext-java line-numbers-mode"><pre class="language-java"><code><span class="token keyword">public</span> <span class="token keyword">class</span> <span class="token class-name">ListStack</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">Item</span><span class="token punctuation">&gt;</span></span> <span class="token keyword">implements</span> <span class="token class-name">MyStack</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">Item</span><span class="token punctuation">&gt;</span></span> <span class="token punctuation">{</span>

    <span class="token keyword">private</span> <span class="token class-name">Node</span> top <span class="token operator">=</span> <span class="token keyword">null</span><span class="token punctuation">;</span>
    <span class="token keyword">private</span> <span class="token keyword">int</span> <span class="token class-name">N</span> <span class="token operator">=</span> <span class="token number">0</span><span class="token punctuation">;</span>


    <span class="token keyword">private</span> <span class="token keyword">class</span> <span class="token class-name">Node</span> <span class="token punctuation">{</span>
        <span class="token class-name">Item</span> item<span class="token punctuation">;</span>
        <span class="token class-name">Node</span> next<span class="token punctuation">;</span>
    <span class="token punctuation">}</span>


    <span class="token annotation punctuation">@Override</span>
    <span class="token keyword">public</span> <span class="token class-name">MyStack</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">Item</span><span class="token punctuation">&gt;</span></span> <span class="token function">push</span><span class="token punctuation">(</span><span class="token class-name">Item</span> item<span class="token punctuation">)</span> <span class="token punctuation">{</span>

        <span class="token class-name">Node</span> newTop <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">Node</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>

        newTop<span class="token punctuation">.</span>item <span class="token operator">=</span> item<span class="token punctuation">;</span>
        newTop<span class="token punctuation">.</span>next <span class="token operator">=</span> top<span class="token punctuation">;</span>

        top <span class="token operator">=</span> newTop<span class="token punctuation">;</span>

        <span class="token class-name">N</span><span class="token operator">++</span><span class="token punctuation">;</span>

        <span class="token keyword">return</span> <span class="token keyword">this</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>


    <span class="token annotation punctuation">@Override</span>
    <span class="token keyword">public</span> <span class="token class-name">Item</span> <span class="token function">pop</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token keyword">throws</span> <span class="token class-name">Exception</span> <span class="token punctuation">{</span>

        <span class="token keyword">if</span> <span class="token punctuation">(</span><span class="token function">isEmpty</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
            <span class="token keyword">throw</span> <span class="token keyword">new</span> <span class="token class-name">Exception</span><span class="token punctuation">(</span><span class="token string">&quot;stack is empty&quot;</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token punctuation">}</span>

        <span class="token class-name">Item</span> item <span class="token operator">=</span> top<span class="token punctuation">.</span>item<span class="token punctuation">;</span>

        top <span class="token operator">=</span> top<span class="token punctuation">.</span>next<span class="token punctuation">;</span>
        <span class="token class-name">N</span><span class="token operator">--</span><span class="token punctuation">;</span>

        <span class="token keyword">return</span> item<span class="token punctuation">;</span>
    <span class="token punctuation">}</span>


    <span class="token annotation punctuation">@Override</span>
    <span class="token keyword">public</span> <span class="token keyword">boolean</span> <span class="token function">isEmpty</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token keyword">return</span> <span class="token class-name">N</span> <span class="token operator">==</span> <span class="token number">0</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>


    <span class="token annotation punctuation">@Override</span>
    <span class="token keyword">public</span> <span class="token keyword">int</span> <span class="token function">size</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token keyword">return</span> <span class="token class-name">N</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>


    <span class="token annotation punctuation">@Override</span>
    <span class="token keyword">public</span> <span class="token class-name">Iterator</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">Item</span><span class="token punctuation">&gt;</span></span> <span class="token function">iterator</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>

        <span class="token keyword">return</span> <span class="token keyword">new</span> <span class="token class-name">Iterator</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">Item</span><span class="token punctuation">&gt;</span></span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>

            <span class="token keyword">private</span> <span class="token class-name">Node</span> cur <span class="token operator">=</span> top<span class="token punctuation">;</span>


            <span class="token annotation punctuation">@Override</span>
            <span class="token keyword">public</span> <span class="token keyword">boolean</span> <span class="token function">hasNext</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
                <span class="token keyword">return</span> cur <span class="token operator">!=</span> <span class="token keyword">null</span><span class="token punctuation">;</span>
            <span class="token punctuation">}</span>


            <span class="token annotation punctuation">@Override</span>
            <span class="token keyword">public</span> <span class="token class-name">Item</span> <span class="token function">next</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
                <span class="token class-name">Item</span> item <span class="token operator">=</span> cur<span class="token punctuation">.</span>item<span class="token punctuation">;</span>
                cur <span class="token operator">=</span> cur<span class="token punctuation">.</span>next<span class="token punctuation">;</span>
                <span class="token keyword">return</span> item<span class="token punctuation">;</span>
            <span class="token punctuation">}</span>
        <span class="token punctuation">}</span><span class="token punctuation">;</span>

    <span class="token punctuation">}</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><span class="line-number">1</span><br><span class="line-number">2</span><br><span class="line-number">3</span><br><span class="line-number">4</span><br><span class="line-number">5</span><br><span class="line-number">6</span><br><span class="line-number">7</span><br><span class="line-number">8</span><br><span class="line-number">9</span><br><span class="line-number">10</span><br><span class="line-number">11</span><br><span class="line-number">12</span><br><span class="line-number">13</span><br><span class="line-number">14</span><br><span class="line-number">15</span><br><span class="line-number">16</span><br><span class="line-number">17</span><br><span class="line-number">18</span><br><span class="line-number">19</span><br><span class="line-number">20</span><br><span class="line-number">21</span><br><span class="line-number">22</span><br><span class="line-number">23</span><br><span class="line-number">24</span><br><span class="line-number">25</span><br><span class="line-number">26</span><br><span class="line-number">27</span><br><span class="line-number">28</span><br><span class="line-number">29</span><br><span class="line-number">30</span><br><span class="line-number">31</span><br><span class="line-number">32</span><br><span class="line-number">33</span><br><span class="line-number">34</span><br><span class="line-number">35</span><br><span class="line-number">36</span><br><span class="line-number">37</span><br><span class="line-number">38</span><br><span class="line-number">39</span><br><span class="line-number">40</span><br><span class="line-number">41</span><br><span class="line-number">42</span><br><span class="line-number">43</span><br><span class="line-number">44</span><br><span class="line-number">45</span><br><span class="line-number">46</span><br><span class="line-number">47</span><br><span class="line-number">48</span><br><span class="line-number">49</span><br><span class="line-number">50</span><br><span class="line-number">51</span><br><span class="line-number">52</span><br><span class="line-number">53</span><br><span class="line-number">54</span><br><span class="line-number">55</span><br><span class="line-number">56</span><br><span class="line-number">57</span><br><span class="line-number">58</span><br><span class="line-number">59</span><br><span class="line-number">60</span><br><span class="line-number">61</span><br><span class="line-number">62</span><br><span class="line-number">63</span><br><span class="line-number">64</span><br><span class="line-number">65</span><br><span class="line-number">66</span><br><span class="line-number">67</span><br><span class="line-number">68</span><br><span class="line-number">69</span><br><span class="line-number">70</span><br><span class="line-number">71</span><br><span class="line-number">72</span><br><span class="line-number">73</span><br><span class="line-number">74</span><br><span class="line-number">75</span><br><span class="line-number">76</span><br><span class="line-number">77</span><br><span class="line-number">78</span><br><span class="line-number">79</span><br><span class="line-number">80</span><br></div></div><h1 id="\u961F\u5217" tabindex="-1"><a class="header-anchor" href="#\u961F\u5217" aria-hidden="true">#</a> \u961F\u5217</h1><p>\u4E0B\u9762\u662F\u961F\u5217\u7684\u94FE\u8868\u5B9E\u73B0\uFF0C\u9700\u8981\u7EF4\u62A4 first \u548C last \u8282\u70B9\u6307\u9488\uFF0C\u5206\u522B\u6307\u5411\u961F\u9996\u548C\u961F\u5C3E\u3002</p><p>\u8FD9\u91CC\u9700\u8981\u8003\u8651 first \u548C last \u6307\u9488\u54EA\u4E2A\u4F5C\u4E3A\u94FE\u8868\u7684\u5F00\u5934\u3002\u56E0\u4E3A\u51FA\u961F\u5217\u64CD\u4F5C\u9700\u8981\u8BA9\u961F\u9996\u5143\u7D20\u7684\u4E0B\u4E00\u4E2A\u5143\u7D20\u6210\u4E3A\u961F\u9996\uFF0C\u6240\u4EE5\u9700\u8981\u5BB9\u6613\u83B7\u53D6\u4E0B\u4E00\u4E2A\u5143\u7D20\uFF0C\u800C\u94FE\u8868\u7684\u5934\u90E8\u8282\u70B9\u7684 next \u6307\u9488\u6307\u5411\u4E0B\u4E00\u4E2A\u5143\u7D20\uFF0C\u56E0\u6B64\u53EF\u4EE5\u8BA9 first \u6307\u9488\u94FE\u8868\u7684\u5F00\u5934\u3002</p><div class="language-java ext-java line-numbers-mode"><pre class="language-java"><code><span class="token keyword">public</span> <span class="token keyword">interface</span> <span class="token class-name">MyQueue</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">Item</span><span class="token punctuation">&gt;</span></span> <span class="token keyword">extends</span> <span class="token class-name">Iterable</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">Item</span><span class="token punctuation">&gt;</span></span> <span class="token punctuation">{</span>

    <span class="token keyword">int</span> <span class="token function">size</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>

    <span class="token keyword">boolean</span> <span class="token function">isEmpty</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>

    <span class="token class-name">MyQueue</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">Item</span><span class="token punctuation">&gt;</span></span> <span class="token function">add</span><span class="token punctuation">(</span><span class="token class-name">Item</span> item<span class="token punctuation">)</span><span class="token punctuation">;</span>

    <span class="token class-name">Item</span> <span class="token function">remove</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token keyword">throws</span> <span class="token class-name">Exception</span><span class="token punctuation">;</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><span class="line-number">1</span><br><span class="line-number">2</span><br><span class="line-number">3</span><br><span class="line-number">4</span><br><span class="line-number">5</span><br><span class="line-number">6</span><br><span class="line-number">7</span><br><span class="line-number">8</span><br><span class="line-number">9</span><br><span class="line-number">10</span><br></div></div><div class="language-java ext-java line-numbers-mode"><pre class="language-java"><code><span class="token keyword">public</span> <span class="token keyword">class</span> <span class="token class-name">ListQueue</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">Item</span><span class="token punctuation">&gt;</span></span> <span class="token keyword">implements</span> <span class="token class-name">MyQueue</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">Item</span><span class="token punctuation">&gt;</span></span> <span class="token punctuation">{</span>

    <span class="token keyword">private</span> <span class="token class-name">Node</span> first<span class="token punctuation">;</span>
    <span class="token keyword">private</span> <span class="token class-name">Node</span> last<span class="token punctuation">;</span>
    <span class="token keyword">int</span> <span class="token class-name">N</span> <span class="token operator">=</span> <span class="token number">0</span><span class="token punctuation">;</span>


    <span class="token keyword">private</span> <span class="token keyword">class</span> <span class="token class-name">Node</span> <span class="token punctuation">{</span>
        <span class="token class-name">Item</span> item<span class="token punctuation">;</span>
        <span class="token class-name">Node</span> next<span class="token punctuation">;</span>
    <span class="token punctuation">}</span>


    <span class="token annotation punctuation">@Override</span>
    <span class="token keyword">public</span> <span class="token keyword">boolean</span> <span class="token function">isEmpty</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token keyword">return</span> <span class="token class-name">N</span> <span class="token operator">==</span> <span class="token number">0</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>


    <span class="token annotation punctuation">@Override</span>
    <span class="token keyword">public</span> <span class="token keyword">int</span> <span class="token function">size</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token keyword">return</span> <span class="token class-name">N</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>


    <span class="token annotation punctuation">@Override</span>
    <span class="token keyword">public</span> <span class="token class-name">MyQueue</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">Item</span><span class="token punctuation">&gt;</span></span> <span class="token function">add</span><span class="token punctuation">(</span><span class="token class-name">Item</span> item<span class="token punctuation">)</span> <span class="token punctuation">{</span>

        <span class="token class-name">Node</span> newNode <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">Node</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        newNode<span class="token punctuation">.</span>item <span class="token operator">=</span> item<span class="token punctuation">;</span>
        newNode<span class="token punctuation">.</span>next <span class="token operator">=</span> <span class="token keyword">null</span><span class="token punctuation">;</span>

        <span class="token keyword">if</span> <span class="token punctuation">(</span><span class="token function">isEmpty</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
            last <span class="token operator">=</span> newNode<span class="token punctuation">;</span>
            first <span class="token operator">=</span> newNode<span class="token punctuation">;</span>
        <span class="token punctuation">}</span> <span class="token keyword">else</span> <span class="token punctuation">{</span>
            last<span class="token punctuation">.</span>next <span class="token operator">=</span> newNode<span class="token punctuation">;</span>
            last <span class="token operator">=</span> newNode<span class="token punctuation">;</span>
        <span class="token punctuation">}</span>

        <span class="token class-name">N</span><span class="token operator">++</span><span class="token punctuation">;</span>
        <span class="token keyword">return</span> <span class="token keyword">this</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>


    <span class="token annotation punctuation">@Override</span>
    <span class="token keyword">public</span> <span class="token class-name">Item</span> <span class="token function">remove</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token keyword">throws</span> <span class="token class-name">Exception</span> <span class="token punctuation">{</span>

        <span class="token keyword">if</span> <span class="token punctuation">(</span><span class="token function">isEmpty</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
            <span class="token keyword">throw</span> <span class="token keyword">new</span> <span class="token class-name">Exception</span><span class="token punctuation">(</span><span class="token string">&quot;queue is empty&quot;</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token punctuation">}</span>

        <span class="token class-name">Node</span> node <span class="token operator">=</span> first<span class="token punctuation">;</span>
        first <span class="token operator">=</span> first<span class="token punctuation">.</span>next<span class="token punctuation">;</span>
        <span class="token class-name">N</span><span class="token operator">--</span><span class="token punctuation">;</span>

        <span class="token keyword">if</span> <span class="token punctuation">(</span><span class="token function">isEmpty</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
            last <span class="token operator">=</span> <span class="token keyword">null</span><span class="token punctuation">;</span>
        <span class="token punctuation">}</span>

        <span class="token keyword">return</span> node<span class="token punctuation">.</span>item<span class="token punctuation">;</span>
    <span class="token punctuation">}</span>


    <span class="token annotation punctuation">@Override</span>
    <span class="token keyword">public</span> <span class="token class-name">Iterator</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">Item</span><span class="token punctuation">&gt;</span></span> <span class="token function">iterator</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>

        <span class="token keyword">return</span> <span class="token keyword">new</span> <span class="token class-name">Iterator</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">Item</span><span class="token punctuation">&gt;</span></span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>

            <span class="token class-name">Node</span> cur <span class="token operator">=</span> first<span class="token punctuation">;</span>


            <span class="token annotation punctuation">@Override</span>
            <span class="token keyword">public</span> <span class="token keyword">boolean</span> <span class="token function">hasNext</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
                <span class="token keyword">return</span> cur <span class="token operator">!=</span> <span class="token keyword">null</span><span class="token punctuation">;</span>
            <span class="token punctuation">}</span>


            <span class="token annotation punctuation">@Override</span>
            <span class="token keyword">public</span> <span class="token class-name">Item</span> <span class="token function">next</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
                <span class="token class-name">Item</span> item <span class="token operator">=</span> cur<span class="token punctuation">.</span>item<span class="token punctuation">;</span>
                cur <span class="token operator">=</span> cur<span class="token punctuation">.</span>next<span class="token punctuation">;</span>
                <span class="token keyword">return</span> item<span class="token punctuation">;</span>
            <span class="token punctuation">}</span>
        <span class="token punctuation">}</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><span class="line-number">1</span><br><span class="line-number">2</span><br><span class="line-number">3</span><br><span class="line-number">4</span><br><span class="line-number">5</span><br><span class="line-number">6</span><br><span class="line-number">7</span><br><span class="line-number">8</span><br><span class="line-number">9</span><br><span class="line-number">10</span><br><span class="line-number">11</span><br><span class="line-number">12</span><br><span class="line-number">13</span><br><span class="line-number">14</span><br><span class="line-number">15</span><br><span class="line-number">16</span><br><span class="line-number">17</span><br><span class="line-number">18</span><br><span class="line-number">19</span><br><span class="line-number">20</span><br><span class="line-number">21</span><br><span class="line-number">22</span><br><span class="line-number">23</span><br><span class="line-number">24</span><br><span class="line-number">25</span><br><span class="line-number">26</span><br><span class="line-number">27</span><br><span class="line-number">28</span><br><span class="line-number">29</span><br><span class="line-number">30</span><br><span class="line-number">31</span><br><span class="line-number">32</span><br><span class="line-number">33</span><br><span class="line-number">34</span><br><span class="line-number">35</span><br><span class="line-number">36</span><br><span class="line-number">37</span><br><span class="line-number">38</span><br><span class="line-number">39</span><br><span class="line-number">40</span><br><span class="line-number">41</span><br><span class="line-number">42</span><br><span class="line-number">43</span><br><span class="line-number">44</span><br><span class="line-number">45</span><br><span class="line-number">46</span><br><span class="line-number">47</span><br><span class="line-number">48</span><br><span class="line-number">49</span><br><span class="line-number">50</span><br><span class="line-number">51</span><br><span class="line-number">52</span><br><span class="line-number">53</span><br><span class="line-number">54</span><br><span class="line-number">55</span><br><span class="line-number">56</span><br><span class="line-number">57</span><br><span class="line-number">58</span><br><span class="line-number">59</span><br><span class="line-number">60</span><br><span class="line-number">61</span><br><span class="line-number">62</span><br><span class="line-number">63</span><br><span class="line-number">64</span><br><span class="line-number">65</span><br><span class="line-number">66</span><br><span class="line-number">67</span><br><span class="line-number">68</span><br><span class="line-number">69</span><br><span class="line-number">70</span><br><span class="line-number">71</span><br><span class="line-number">72</span><br><span class="line-number">73</span><br><span class="line-number">74</span><br><span class="line-number">75</span><br><span class="line-number">76</span><br><span class="line-number">77</span><br><span class="line-number">78</span><br><span class="line-number">79</span><br><span class="line-number">80</span><br><span class="line-number">81</span><br><span class="line-number">82</span><br><span class="line-number">83</span><br><span class="line-number">84</span><br><span class="line-number">85</span><br><span class="line-number">86</span><br><span class="line-number">87</span><br></div></div>`,13);function e(t,c){return p}var u=n(a,[["render",e],["__file","\u7B97\u6CD5-\u6808\u548C\u961F\u5217.html.vue"]]);export{u as default};
