package czt.yonyou.dao;

import czt.yonyou.entity.Agent;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AgentRepository extends JpaRepository<Agent,String> {
}
