package br.com.alura.ScreenMatch.Service;

public interface IConverteDados {
    <T> T obterDado(String json,Class <T> classe);
}
