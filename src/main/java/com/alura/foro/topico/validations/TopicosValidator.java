package com.alura.foro.topico.validations;

import com.alura.foro.topico.DataUpdateTopico;
import com.alura.foro.topico.utils.DataNewTopico;

public interface TopicosValidator {
	public void validate(DataNewTopico data);
	public void validate(DataUpdateTopico data);
}
