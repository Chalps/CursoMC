package com.chalps.cursomc.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date instante;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
    private Pagamento pagamento;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "endereco_de_entrega_id")
    private Endereco enderedoDeEntrega;

    public Pedido(){}

    public Pedido(Integer id, Date instante, Cliente cliente, Endereco enderedoDeEntrega) {
        this.id = id;
        this.instante = instante;
        this.cliente = cliente;
        this.enderedoDeEntrega = enderedoDeEntrega;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getInstante() {
        return instante;
    }

    public void setInstante(Date instante) {
        this.instante = instante;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Endereco getEnderedoDeEntrega() {
        return enderedoDeEntrega;
    }

    public void setEnderedoDeEntrega(Endereco enderedoDeEntrega) {
        this.enderedoDeEntrega = enderedoDeEntrega;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pedido)) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id) && Objects.equals(instante, pedido.instante) && Objects.equals(pagamento, pedido.pagamento) && Objects.equals(cliente, pedido.cliente) && Objects.equals(enderedoDeEntrega, pedido.enderedoDeEntrega);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, instante, pagamento, cliente, enderedoDeEntrega);
    }
}
