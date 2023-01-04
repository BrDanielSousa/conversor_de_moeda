package com.conversordemoedas.repositories;

import com.conversordemoedas.models.HistoricoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HistoricoRepository extends JpaRepository<HistoricoModel, UUID> {
}
