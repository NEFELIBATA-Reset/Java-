package lib;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

/**
 * 核心技术：
 * 1、HtmlUnit 基本使用架构
 * 2、HtmlUnit 模拟浏览器
 *
 * 、静态网页爬取，关闭 CSS、JS 支持，提高速度
 *
 */
public class Demo {
    public static void main(String[] args) {
        // 实例化Web客户端（模拟 Chrome 浏览器 ）
        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        //关闭了浏览器的css执行引擎，不在执行网页中的css布局
        webClient.getOptions().setCssEnabled(false);
        //关闭了浏览器的js执行引擎，不在执行网页中的js脚本
        webClient.getOptions().setJavaScriptEnabled(false);
        try {
            // 解析获取页面
            HtmlPage page = webClient.getPage("https://so.gushiwen.org/gushi/tangshi.aspx");
            /**
             * XPath 是一门在 XML 文档中查找信息的语言。
             * //title[@lang=’eng’]	选取所有 title 元素，且这些元素拥有值为 eng 的 lang 属性。
             *
             * Xpath:级联选择
             * //：从匹配选择的当前节点选择文档中的节点，而不考虑它们的位置
             * h3：匹配<h3>标签
             *  [@class='company_name']：属性名为class的值为company_name
             *  a：匹配<a>标签
             */
            List<HtmlElement> spanList=page.getByXPath("//h3[@class='company_name']/a");

            for(int i=0;i<spanList.size();i++) {
                System.out.println(i+1+"、"+spanList.get(i).asText());
            }

        } catch (FailingHttpStatusCodeException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            webClient.close(); // 关闭客户端，释放内存
        }
    }

}
