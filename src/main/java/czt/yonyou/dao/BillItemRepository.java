package czt.yonyou.dao;

import czt.yonyou.entity.BillItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillItemRepository extends JpaRepository<BillItem,Long> {
}
