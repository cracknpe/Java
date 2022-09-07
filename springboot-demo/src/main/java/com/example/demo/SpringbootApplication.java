package com.example.demo;

import com.example.bean.SearchReq;
import com.example.filter.TransactionFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@SpringBootApplication
@RestController
public class SpringbootApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	/**
	 *通过在本地 127.0.0.1 启动一个web应用，8080端口，用postman来理解正向代理
	 * postman是一款开发测试API的工具
	 * 研究正向代理的过程，是在postman的proxy设置中填入proxy的地址和端口号：127.0.0.1:8080
	 * 然后通过访问任意的网址，都能转发到proxy中的地址
	 * 比如访问http://a.b.c/search, 就会转发到127.0.0.1:8080这个应用的search接口，此时启动的
	 * 这个web应用相当于就是一个proxy。
	 * 当请求a.b.c/search这个URL的时候，在web应用中可以获取到a.b.c这个域名，然后进行转发即可。
	 * 可以将a.b.c这个服务在本地再模拟一个web应用，然后在7070端口启动，其实上面的这个web proxy就相当于一个
	 * nginx的效果，也跟burpsuit这个工具类似
	 *
	 * 可以用同样的方式来去理解一个反向代理的过程
	 *
	 * 反过来说，这些proxy其实也相当于一个流量劫持的中间人插件，类似于这样功能的，比较经典的
	 * 还有tcpdump这个专门做流量嗅探的工具，但是所不同的是tcpdump可以劫持跟web应用同一个端口（比如：8080）的流量，
	 * 于是好奇用一个其他java应用去劫持8080端口的流量，发现监听失败，因为8080端口已经被使用了，显然
	 * tcpdump不是通过这种方式来做嗅探的，可能是通过内核、网卡等方式，因为使用的时候也必须要sudo权限，所以大胆猜测不是在
	 * 用户层可以做到的，具体的实现方式未深入研究过,比如用tcpdump来抓8080端口的包：
	 * sudo tcpdump -A -s 0 'tcp port 8080 and (((ip[2:2] - ((ip[0]&0xf)<<2)) - ((tcp[12]&0xf0)>>2)) != 0)' -i lo0
	 *
	 * 同时也查询了网上关于监听同一个端口的方法，大部分的说法是如果ip不是同一个，可以监听同一端口，类似这样：
	 * 127.0.0.1:8080 , 192.168.0.1:8080 , 可能这样的元组组合会被识别为不同的监听地址，未验证。
	 *
	 * 也看到一个链接，说是linux 内核3.9以后已经可以允许多个应用在同一个ip、同一个port处进行监听了，未验证，参考下面
	 * 链接：https://lwn.net/Articles/542629/
	 *
	 * 在看proxy的时候，正好也看到一个haproxy的组件，用来做高可用、复杂均衡、流量转发可以用，参考以下链接：
	 * https://www.haproxy.com/blog/truly-seamless-reloads-with-haproxy-no-more-hacks/
	 *
	 * 比较有名的抓包、流量嗅探工具：tcpdump，wireshark（UI）
	 * 正好想起来也许ebpf在这方面会有更好的方式可以玩。
	 *
	 *
	 *
	 * @param req
	 * @param searchReq
	 * @return
	 *
	 */
	@PostMapping("/search")
	public String search(HttpServletRequest req, @RequestBody SearchReq searchReq){
		System.out.println(searchReq.getSearchParam());
		System.out.println(searchReq.getNumber());
		System.out.println(searchReq.isValid());
		return String.format("search");
	}

	@Bean
	public FilterRegistrationBean<TransactionFilter> registration() {
		TransactionFilter transactionFilter = new TransactionFilter();
		FilterRegistrationBean<TransactionFilter> registration = new FilterRegistrationBean<>(transactionFilter);
		registration.addUrlPatterns("/*");
		registration.setOrder(1);
		return registration;
	}
}
