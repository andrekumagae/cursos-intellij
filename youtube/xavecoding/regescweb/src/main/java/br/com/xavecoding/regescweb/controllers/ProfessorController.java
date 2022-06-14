package br.com.xavecoding.regescweb.controllers;

import br.com.xavecoding.regescweb.dto.RequisicaoFormProfessor;
import br.com.xavecoding.regescweb.models.Professor;
import br.com.xavecoding.regescweb.models.StatusProfessor;
import br.com.xavecoding.regescweb.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/*Deve ser usada esta anotação para que o controller consiga chamar a página*/

@Controller
/*Deixar a página /professores como um prefixo de todas as outras*/
@RequestMapping(value = "/professores")
public class ProfessorController {
    /*Anotação para criar um objeto e injetar a dependencia do repositorio*/
    @Autowired
    private ProfessorRepository professorRepository;

    /*GetMapping serve para chamar a pagina ao inserir este diretório na url*/
    @GetMapping("")
    public ModelAndView index() {

        /*Adicionando pelo jpaRepository*/
        List<Professor> professores = this.professorRepository.findAll();

        /*Forma manual de adicionar dados na lista
         *//*Diretório do arquivo url*//*
        Professor batman = new Professor("Batman", new BigDecimal("5000.0"), StatusProfessor.ATIVO);
        *//*Modificamos o valor do ID com formato Long*//*
        batman.setId(1L);
        Professor coringa = new Professor("Coringa", new BigDecimal("10000.0"), StatusProfessor.APOSENTADO);
        coringa.setId(2L);
        Professor mulherMaravilha = new Professor("Mulher Maravilha", new BigDecimal("15000.0"),
                StatusProfessor.INVATIVO);
        mulherMaravilha.setId(3L);
        *//*Criamos um Array com os professores *//*
        List<Professor> professores = Arrays.asList(batman, coringa, mulherMaravilha);*/

        /*Usamos o método de objeto pela classe ModelAndView*/
        ModelAndView mv = new ModelAndView("professores/index");
        /*Podemos adicionar a lista toda */
        mv.addObject("professores", professores);
        return mv;
    }

    @GetMapping("/new")
    public ModelAndView nnew(RequisicaoFormProfessor requisicao) {
        ModelAndView mv = new ModelAndView("professores/new");
        mv.addObject("listaStatusProfessor", StatusProfessor.values());
        return mv;
    }


    /*Recebemos um objeto da nossa classe DTO*/
    @PostMapping("")
    /*Usamos a anotação @Valid para que funcione as validações NotNull e o argumento BindingResult para pegar o erro*/
    public ModelAndView create(@Valid RequisicaoFormProfessor requisicao, BindingResult bindingResult) {
        System.out.println(requisicao);
        if (bindingResult.hasErrors()) {
            System.out.println("***** TEM ERROS *****");
            ModelAndView mv = new ModelAndView("professores/new");
            mv.addObject("listaStatusProfessor", StatusProfessor.values());
            return mv;
        } else {

            Professor professor = requisicao.toProfessor();
            /*Método para salvar no banco de dados*/
            this.professorRepository.save(professor);
            return new ModelAndView("redirect:/professores/" + professor.getId());
        }
    }

    @GetMapping("/{id}")
    /*Pathvariable pega a variável no caminho da url do GetMapping*/
    public ModelAndView show(@PathVariable Long id) {
        Optional<Professor> optional = this.professorRepository.findById(id);
        if (optional.isPresent()) {
            Professor professor = optional.get();
            ModelAndView mv = new ModelAndView("professores/show");
            mv.addObject("professor", professor);
            return mv;
        } else {
            return retornaErroProfessor("SHOW ERROR: Professor #" + id + " não encontrado no banco!");
        }
    }

    @GetMapping("/{id}/edit")
    /*Pathvariable pega a variável no caminho da url do GetMapping*/
    public ModelAndView edit(@PathVariable Long id, RequisicaoFormProfessor requisicao) {
        Optional<Professor> optional = this.professorRepository.findById(id);
        if (optional.isPresent()) {
            Professor professor = optional.get();
            requisicao.fromProfessor(professor);
            ModelAndView mv = new ModelAndView("professores/edit");
            mv.addObject("professorId", professor.getId());
            mv.addObject("listaStatusProfessor", StatusProfessor.values());
            return mv;
        } else {
            return retornaErroProfessor("EDIT ERROR: Professor #" + id + " não encontrado no banco!");
        }
    }

    @PostMapping("/{id}")
    public ModelAndView update(@PathVariable Long id, RequisicaoFormProfessor requisicao, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ModelAndView mv = new ModelAndView("professores/edit");
            mv.addObject("professorId", id);
            mv.addObject("listaStatusProfessor", StatusProfessor.values());
            return mv;
        } else {
            Optional<Professor> optional = this.professorRepository.findById(id);
            if (optional.isPresent()) {
                Professor professor = requisicao.toProfessor(optional.get());
                this.professorRepository.save(professor);
                return new ModelAndView("redirect:/professores/" + professor.getId());
            } else {
                return retornaErroProfessor("UPDATE ERROR: Professor #" + id + " não encontrado no banco!");
            }
        }
    }

    @GetMapping("/{id}/delete")
    public ModelAndView delete(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("redirect:/professores");
        try {
            this.professorRepository.deleteById(id);
            mv.addObject("mensagem", "Professor #" + id + " deletado com sucesso!");
            mv.addObject("erro", false);
            /*Exceção para caso digitem ids que não existem*/
        } catch (EmptyResultDataAccessException e) {
            mv = this.retornaErroProfessor("DELETE ERROR: Professor #" + id + " não encontrado no banco!");
        }
        return mv;
    }

    /*Função que mostra mensagem de erro*/
    private ModelAndView retornaErroProfessor(String msg) {
        ModelAndView mv = new ModelAndView("redirect:/professores");
        mv.addObject("mensagem", msg);
        mv.addObject("erro", true);
        return mv;
    }
}























