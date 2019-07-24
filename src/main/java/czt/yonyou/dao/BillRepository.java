package czt.yonyou.dao;
/**
 * 上面的代码片所展示的是Spring Data Repository JPA技术，
 * 要使用这项技术只需要继承JpaRepository接口即可。JpaRepository是一个标记接口，
 * 允许Spring Data Repository引擎识别它并提供
 * 必要的代理类来实现基本的CRUD (Create, Read, Update, Delete) 和一些自定义的方法。
 */

import czt.yonyou.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill,Integer>{
}
