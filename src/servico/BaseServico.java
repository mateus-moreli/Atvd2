package servico;
import java.util.ArrayList;

public abstract class BaseServico<TDominio> {
    public abstract ArrayList<TDominio> Browse();
    public abstract TDominio Read(int chave);
    public abstract TDominio Edit(TDominio obj);
    public abstract TDominio Add(TDominio obj);
    public abstract TDominio Delete(int chave);
}
